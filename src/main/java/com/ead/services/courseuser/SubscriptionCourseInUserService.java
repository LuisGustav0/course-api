package com.ead.services.courseuser;

import com.ead.exceptions.UserBlockedException;
import com.ead.model.CourseModel;
import com.ead.model.UserModel;
import com.ead.model.request.courseuser.SubscriptionCourseInUserRequest;
import com.ead.model.response.courseuser.SubscriptionCourseInUserResponse;
import com.ead.services.CourseByIdOrElseThrowService;
import com.ead.services.users.UserByIdOrElseThrowService;
import com.ead.validations.ExistsCourseAndUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class SubscriptionCourseInUserService {

    private final CourseByIdOrElseThrowService courseByIdOrElseThrowService;
    private final UserByIdOrElseThrowService userByIdOrElseThrowService;

    private final ExistsCourseAndUserService existsCourseAndUserService;

    private final SaveCourseAndUserAndSendNotificationService saveCourseAndUserAndSendNotificationService;

    public SubscriptionCourseInUserResponse call(final UUID courseId,
                                                 final SubscriptionCourseInUserRequest request) {
        log.info("SubscriptionCourseInUserService.call Request: {}", request);

        final CourseModel course = this.courseByIdOrElseThrowService.call(courseId);
        log.info("SubscriptionCourseInUserService.call Course: {}", course);

        final UserModel user = this.userByIdOrElseThrowService.call(request.getUserId());
        log.info("SubscriptionCourseInUserService.call User: {}", user);

        this.existsCourseAndUserService.call(courseId, user.getId());

        if (user.isBlocked())
            throw new UserBlockedException();

        this.saveCourseAndUserAndSendNotificationService.call(course, user);

        return SubscriptionCourseInUserResponse.builder()
                                               .message("Inscrição de curso com usuário criado com sucesso!")
                                               .build();
    }
}
