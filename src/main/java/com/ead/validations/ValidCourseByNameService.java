package com.ead.validations;

import com.ead.exceptions.CourseExistsByNameException;
import com.ead.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ValidCourseByNameService {

    private final CourseRepository repository;

    public void callDifferentId(final String description, final UUID id) {
        if (this.repository.isExistsByNameDifferentById(description, id))
            throw new CourseExistsByNameException();
    }

    public void call(final String description) {
        if (this.repository.existsByName(description))
            throw new CourseExistsByNameException();
    }
}
