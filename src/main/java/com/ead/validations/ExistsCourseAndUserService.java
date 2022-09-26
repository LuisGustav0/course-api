package com.ead.validations;

import com.ead.exceptions.SubscriptionCourseAndUserExistsException;
import com.ead.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExistsCourseAndUserService {

    private final CourseRepository repository;

    public void call(final UUID courseId, final UUID userId) {
        if (this.repository.isExistsByCourseAndUser(courseId, userId))
            throw new SubscriptionCourseAndUserExistsException();
    }
}
