package com.ead.repositories;

import com.ead.model.CourseUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseUserRepository extends JpaRepository<CourseUserModel, UUID> {

    boolean existsByCourseIdAndUserId(final UUID courseId, final UUID userId);

    List<CourseUserModel> findAllByCourseId(final UUID courseId);

    void deleteByUserId(final UUID userId);
}
