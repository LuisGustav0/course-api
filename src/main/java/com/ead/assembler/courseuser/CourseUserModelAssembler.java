package com.ead.assembler.courseuser;

import com.ead.model.CourseUserModel;
import com.ead.model.response.CourseResponse;
import com.ead.model.response.courseuser.SubscriptionUserInCourseResponse;
import org.springframework.stereotype.Component;

@Component
public class CourseUserModelAssembler {


    public SubscriptionUserInCourseResponse toResponse(final CourseUserModel courseUser) {
        final var userResponse = SubscriptionUserInCourseResponse.UserResponse
                .builder()
                .id(courseUser.getId())
                .build();

        final CourseResponse courseResponse = CourseResponse.builder()
                                                            .id(courseUser.getCourse().getId())
                                                            .description(courseUser.getCourse().getDescription())
                                                            .build();

        return SubscriptionUserInCourseResponse.builder()
                                               .id(courseUser.getId())
                                               .course(courseResponse)
                                               .user(userResponse)
                                               .build();
    }
}
