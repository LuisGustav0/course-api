package com.ead.resources.courseuser;

import com.ead.model.request.courseuser.UserSubscriptionInCourseRequest;
import com.ead.model.response.courseuser.UserSubscriptionInCourseResponse;
import com.ead.services.courseuser.SubscriptionUserInCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SubscriptionUserInCourseResource {

    private final SubscriptionUserInCourseService service;

    @PostMapping("/courses/{courseId}/users/subscription")
    public ResponseEntity<UserSubscriptionInCourseResponse> call(@PathVariable UUID courseId,
                                                                 @RequestBody @Valid UserSubscriptionInCourseRequest request) {

        final UserSubscriptionInCourseResponse response = this.service.call(courseId, request);

        return ResponseEntity.ok(response);
    }
}
