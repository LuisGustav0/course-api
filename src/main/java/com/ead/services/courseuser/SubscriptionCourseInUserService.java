package com.ead.services.courseuser;

import com.ead.assembler.courseuser.CourseUserModelAssembler;
import com.ead.model.CourseModel;
import com.ead.model.CourseUserModel;
import com.ead.model.request.courseuser.SubscriptionCourseInUserRequest;
import com.ead.model.response.courseuser.SubscriptionCourseInUserResponse;
import com.ead.model.response.users.UserResponse;
import com.ead.services.CourseByIdOrElseThrowService;
import com.ead.services.users.UserByIdOrElseThrowService;
import com.ead.validations.ExistsCourseIdAndUserIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionCourseInUserService {

    private final CourseUserModelAssembler assembler;

    private final SaveAndSubscribeUserInCourse saveAndSubscribeUserInCourse;

    private final UserByIdOrElseThrowService userByIdOrElseThrowService;
    private final ExistsCourseIdAndUserIdService existsCourseIdAndUserIdService;
    private final CourseByIdOrElseThrowService findCourseByIdOrElseThrowService;

    public SubscriptionCourseInUserResponse call(final UUID courseId,
                                                 final SubscriptionCourseInUserRequest request) {
        final CourseModel course = this.findCourseByIdOrElseThrowService.call(courseId);

        this.existsCourseIdAndUserIdService.call(course.getId(), request.getUserId());

        final UserResponse user = this.userByIdOrElseThrowService.call(request.getUserId());

        final CourseUserModel courseUser = new CourseUserModel(course, user.getId());

        final CourseUserModel courseUserSaved = this.saveAndSubscribeUserInCourse.call(courseUser);

        return this.assembler.toResponse(courseUserSaved, user);
    }
}
