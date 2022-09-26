package com.ead.services.courseuser;

import com.ead.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaveCourseAndUserService {

    private final CourseRepository repository;

    @Transactional
    public void call(final UUID courseId, final UUID userId) {
        this.repository.saveCourseAndUser(courseId, userId);
    }
}
