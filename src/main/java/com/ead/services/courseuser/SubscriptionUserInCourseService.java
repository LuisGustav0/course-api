package com.ead.services.courseuser;

import com.ead.model.CourseModel;
import com.ead.model.CourseUserModel;
import com.ead.repositories.CourseUserRepository;
import com.ead.model.request.courseuser.UserSubscriptionInCourseRequest;
import com.ead.model.response.courseuser.UserSubscriptionInCourseResponse;
import com.ead.services.CourseByIdOrElseThrowService;
import com.ead.validations.ValidExistsCourseIdAndUserIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionUserInCourseService {

    private final CourseUserRepository repository;

    private final CourseByIdOrElseThrowService findCourseByIdOrElseThrowService;

    private final ValidExistsCourseIdAndUserIdService validExistsCourseIdAndUserIdService;

    public UserSubscriptionInCourseResponse call(final UUID courseId,
                                                 final UserSubscriptionInCourseRequest request) {
        final CourseModel course = this.findCourseByIdOrElseThrowService.call(courseId);

        this.validExistsCourseIdAndUserIdService.call(course.getId(), request.getUserId());

        final CourseUserModel courseUser = new CourseUserModel(course, request.getUserId());

        final CourseUserModel courseUserSaved = this.repository.save(courseUser);

        return UserSubscriptionInCourseResponse.builder().build();
    }
}
