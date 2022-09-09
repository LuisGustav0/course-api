package com.ead.services.courseuser;

import com.ead.assembler.courseuser.CourseUserModelAssembler;
import com.ead.model.CourseModel;
import com.ead.model.CourseUserModel;
import com.ead.model.request.courseuser.SubscriptionUserInCourseRequest;
import com.ead.model.response.courseuser.SubscriptionUserInCourseResponse;
import com.ead.model.response.users.UserResponse;
import com.ead.repositories.CourseUserRepository;
import com.ead.services.CourseByIdOrElseThrowService;
import com.ead.services.users.UserByIdOrElseThrowService;
import com.ead.validations.ExistsCourseIdAndUserIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionUserInCourseService {

    private final CourseUserRepository repository;

    private final CourseUserModelAssembler assembler;

    private final UserByIdOrElseThrowService userByIdOrElseThrowService;
    private final ExistsCourseIdAndUserIdService existsCourseIdAndUserIdService;
    private final CourseByIdOrElseThrowService findCourseByIdOrElseThrowService;

    public SubscriptionUserInCourseResponse call(final UUID courseId,
                                                 final SubscriptionUserInCourseRequest request) {
        final CourseModel course = this.findCourseByIdOrElseThrowService.call(courseId);

        this.existsCourseIdAndUserIdService.call(course.getId(), request.getUserId());

        final UserResponse user = this.userByIdOrElseThrowService.call(request.getUserId());

        final CourseUserModel courseUser = new CourseUserModel(course, user.getId());

        final CourseUserModel courseUserSaved = this.repository.save(courseUser);

        return this.assembler.toResponse(courseUserSaved, user);
    }
}
