package com.ead.model.response.courseuser;

import com.ead.model.response.CourseResponse;
import com.ead.model.response.users.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionCourseInUserResponse {

    private UUID id;
    private CourseResponse course;
    private UserResponse user;
}
