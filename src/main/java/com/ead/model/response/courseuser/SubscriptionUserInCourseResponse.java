package com.ead.model.response.courseuser;

import com.ead.model.response.CourseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionUserInCourseResponse {

    private UUID id;
    private UserResponse user;
    private CourseResponse course;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserResponse {

        private UUID id;
    }
}
