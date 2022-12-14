package com.ead.repositories;

import com.ead.model.LessonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LessonRepository extends JpaRepository<LessonModel, UUID>,
        JpaSpecificationExecutor<LessonModel> {

    @Query(
            value = "SELECT " +
                    "   * " +
                    "FROM lessons " +
                    "WHERE module_id = :moduleId",
            nativeQuery = true
    )
    List<LessonModel> findAllByModuleId(@Param("moduleId") UUID moduleId);

    Optional<LessonModel> findByIdAndModuleId(final UUID id, final UUID moduleId);
}
