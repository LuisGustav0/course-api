package com.ead.services.courses;

import com.ead.exceptions.CourseNotFoundException;
import com.ead.model.CourseModel;
import com.ead.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindCourseByIdOrElseThrowService {

    private final CourseRepository repository;

    public CourseModel call(final UUID id) {
        return this.repository.findById(id).orElseThrow(CourseNotFoundException::new);
    }
}
