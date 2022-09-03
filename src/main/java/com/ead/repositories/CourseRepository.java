package com.ead.repositories;

import com.ead.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseModel, UUID> {

}
