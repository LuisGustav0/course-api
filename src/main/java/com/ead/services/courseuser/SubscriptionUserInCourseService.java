package com.ead.services.courseuser;

import com.ead.assembler.courseuser.CourseUserModelAssembler;
import com.ead.model.CourseModel;
import com.ead.model.CourseUserModel;
import com.ead.repositories.CourseUserRepository;
import com.ead.model.request.courseuser.SubscriptionUserInCourseRequest;
import com.ead.model.response.courseuser.SubscriptionUserInCourseResponse;
import com.ead.services.CourseByIdOrElseThrowService;
import com.ead.validations.ValidExistsCourseIdAndUserIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionUserInCourseService {

    private final CourseUserRepository repository;

    private final CourseUserModelAssembler assembler;

    private final CourseByIdOrElseThrowService findCourseByIdOrElseThrowService;
    private final ValidExistsCourseIdAndUserIdService validExistsCourseIdAndUserIdService;

    public SubscriptionUserInCourseResponse call(final UUID courseId,
                                                 final SubscriptionUserInCourseRequest request) {
        final CourseModel course = this.findCourseByIdOrElseThrowService.call(courseId);

        this.validExistsCourseIdAndUserIdService.call(course.getId(), request.getUserId());

        final CourseUserModel courseUser = new CourseUserModel(course, request.getUserId());

        final CourseUserModel courseUserSaved = this.repository.save(courseUser);

        return this.assembler.toResponse(courseUserSaved);
    }
}
