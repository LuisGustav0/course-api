package com.ead.repositories;

import com.ead.model.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {

    //    @Query(
//            value = "SELECT " +
//                    "   * " +
//                    "FROM modules " +
//                    "WHERE course_id = :courseId",
//            nativeQuery = true
//    )
    List<ModuleModel> findAllByCourseId(@Param("courseId") UUID courseId);

//    @Query(
//            value = "SELECT " +
//                    "   * " +
//                    "FROM modules " +
//                    "WHERE course_id = :courseId" +
//                    "   AND id = :id",
//            nativeQuery = true
//    )
//    Optional<ModuleModel> findByIdAndCourseId(@Param("courseId") UUID courseId, @Param("id") UUID id);

    Optional<ModuleModel> findByIdAndCourseId(@Param("id") UUID id, @Param("courseId") UUID courseId);
}
