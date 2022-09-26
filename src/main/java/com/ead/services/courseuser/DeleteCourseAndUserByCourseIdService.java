package com.ead.services.courseuser;

import com.ead.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCourseAndUserByCourseIdService {

    private final CourseRepository repository;

    @Transactional
    public void call(final UUID courseId) {
        this.repository.deleteCourseAndUserByCourseId(courseId);
    }
}
