package com.ead.assembler.courseuser;

import com.ead.model.CourseUserModel;
import com.ead.model.response.CourseResponse;
import com.ead.model.response.courseuser.SubscriptionUserInCourseResponse;
import com.ead.model.response.users.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class CourseUserModelAssembler {

    public SubscriptionUserInCourseResponse toResponse(final CourseUserModel courseUser,
                                                       final UserResponse userResponse) {
        final UserResponse user = UserResponse.builder()
                                              .id(userResponse.getId())
                                              .fullName(userResponse.getFullName())
                                              .build();

        final CourseResponse course = CourseResponse.builder()
                                                    .id(courseUser.getCourse().getId())
                                                    .description(courseUser.getCourse().getName())
                                                    .build();

        return SubscriptionUserInCourseResponse.builder()
                                               .id(courseUser.getId())
                                               .course(course)
                                               .user(user)
                                               .build();
    }
}
