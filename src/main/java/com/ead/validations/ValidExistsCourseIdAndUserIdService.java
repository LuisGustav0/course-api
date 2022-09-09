package com.ead.validations;

import com.ead.exceptions.SubscriptionCourseAndUserExistsException;
import com.ead.repositories.CourseUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ValidExistsCourseIdAndUserIdService {

    private final CourseUserRepository repository;

    public void call(final UUID courseId, final UUID userId) {
        if (this.repository.existsByCourseIdAndUserId(courseId, userId))
            throw new SubscriptionCourseAndUserExistsException();
    }
}
