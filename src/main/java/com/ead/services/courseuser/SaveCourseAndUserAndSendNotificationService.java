package com.ead.services.courseuser;

import com.ead.model.CourseModel;
import com.ead.model.UserModel;
import com.ead.model.request.notification.NotificationCommandRequest;
import com.ead.publishers.NotificationPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.lang.String.format;

@Log4j2
@Service
@RequiredArgsConstructor
public class SaveCourseAndUserAndSendNotificationService {

    private final SaveCourseAndUserService saveCourseAndUserService;

    private final NotificationPublisher notificationPublisher;

    @Transactional
    public void call(final CourseModel course, final UserModel user) {

        this.saveCourseAndUserService.call(course.getId(), user.getId());
        try {
            String titleFormat = "Bem-vindo(a) ao Curso: %s";
            String messageFormat = "%s a sua inscrição foi realizada com sucesso!";

            var request = NotificationCommandRequest.builder()
                                                    .title(format(titleFormat, course.getName()))
                                                    .message(format(messageFormat, user.getFullName()))
                                                    .userId(user.getId())
                                                    .build();

            this.notificationPublisher.publishNotificationCommand(request);
        } catch (Exception ex) {
            log.error("Error sending notification", ex);
        }
    }
}
