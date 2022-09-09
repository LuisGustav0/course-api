package com.ead.services.courseuser;

import com.ead.clients.authuserapi.SubscriptionUserInCourseClientApi;
import com.ead.model.CourseUserModel;
import com.ead.repositories.CourseUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SaveAndSubscribeUserInCourse {

    private final CourseUserRepository repository;

    private final SubscriptionUserInCourseClientApi subscriptionUserInCourseClientApi;

    @Transactional
    public CourseUserModel call(final CourseUserModel courseUser) {
        final CourseUserModel courseUserSaved = this.repository.save(courseUser);

        this.subscriptionUserInCourseClientApi.call(courseUserSaved.getUserId(), courseUserSaved.getCourse().getId());

        return courseUserSaved;
    }
}
