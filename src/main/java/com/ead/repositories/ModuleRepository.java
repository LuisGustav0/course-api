package com.ead.repositories;

import com.ead.model.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID>,
        JpaSpecificationExecutor<ModuleModel> {

    List<ModuleModel> findAllByCourseId(@Param("courseId") UUID courseId);

    Optional<ModuleModel> findByIdAndCourseId(@Param("id") UUID id, @Param("courseId") UUID courseId);
}
