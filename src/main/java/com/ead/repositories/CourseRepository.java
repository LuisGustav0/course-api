package com.ead.repositories;

import com.ead.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseModel, UUID>,
        JpaSpecificationExecutor<CourseModel> {

    boolean existsByName(final String name);

    @Query("SELECT " +
            "CASE " +
            "   WHEN COUNT(course) > 0 THEN " +
            "       true " +
            "   ELSE " +
            "       false " +
            "END " +
            "FROM CourseModel course " +
            "WHERE course.name like :name" +
            "   AND course.id <> :id")
    boolean isExistsByNameDifferentById(final String name, final UUID id);

    @Query(value = "SELECT " +
            "CASE " +
            "   WHEN COUNT(courseUser) > 0 THEN " +
            "       true " +
            "   ELSE " +
            "       false " +
            "END " +
            "FROM courses_users courseUser " +
            "WHERE courseUser.course_id = :courseId" +
            "   AND courseUser.user_id = :userId", nativeQuery = true)
    boolean isExistsByCourseAndUser(final UUID courseId, final UUID userId);

    @Modifying
    @Query(value = "INSERT INTO courses_users VALUES(:courseId, :userId)", nativeQuery = true)
    void saveCourseAndUser(final UUID courseId, final UUID userId);

    @Modifying
    @Query(value = "DELETE FROM courses_users WHERE course_id = :courseId", nativeQuery = true)
    void deleteCourseAndUserByCourseId(final UUID courseId);

    @Modifying
    @Query(value = "DELETE FROM courses_users WHERE user_id = :userId", nativeQuery = true)
    void deleteCourseAndUserByUserId(final UUID userId);
}
