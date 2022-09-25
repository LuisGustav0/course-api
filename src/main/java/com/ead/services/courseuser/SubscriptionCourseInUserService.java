package com.ead.services.courseuser;

import com.ead.model.CourseModel;
import com.ead.model.request.courseuser.SubscriptionCourseInUserRequest;
import com.ead.model.response.courseuser.SubscriptionCourseInUserResponse;
import com.ead.services.CourseByIdOrElseThrowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class SubscriptionCourseInUserService {

    private final CourseByIdOrElseThrowService findCourseByIdOrElseThrowService;

    public SubscriptionCourseInUserResponse call(final UUID courseId,
                                                 final SubscriptionCourseInUserRequest request) {
        log.info("SubscriptionCourseInUserService.call Request: {}", request);

        final CourseModel course = this.findCourseByIdOrElseThrowService.call(courseId);

        log.info("SubscriptionCourseInUserService.call Course: {}", course);

        return null;
    }
}
