package com.ead.services.courseuser;

import com.ead.model.CourseUserModel;
import com.ead.repositories.CourseUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteAllCourseUserByCourseIdService {

    private final CourseUserRepository repository;

    public void call(final UUID courseId) {
        final List<CourseUserModel> listCourseUser = this.repository.findAllByCourseId(courseId);

        if (listCourseUser.isEmpty())
            return;

        this.repository.deleteAll(listCourseUser);
    }
}
