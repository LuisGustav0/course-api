package com.ead.repositories;

import com.ead.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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
            "WHERE course.name like :description" +
            "   AND course.id <> :id"
    )
    boolean isExistsByNameDifferentById(final String name, final UUID id);
}
