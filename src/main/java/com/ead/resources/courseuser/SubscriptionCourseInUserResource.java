package com.ead.resources.courseuser;

import com.ead.model.request.courseuser.SubscriptionCourseInUserRequest;
import com.ead.model.response.courseuser.SubscriptionCourseInUserResponse;
import com.ead.services.courseuser.SubscriptionCourseInUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SubscriptionCourseInUserResource {

    private final SubscriptionCourseInUserService service;

    @PostMapping("/courses/{courseId}/users/subscription")
    public ResponseEntity<SubscriptionCourseInUserResponse> call(@PathVariable UUID courseId,
                                                                 @RequestBody @Valid SubscriptionCourseInUserRequest request) {
        final SubscriptionCourseInUserResponse response = this.service.call(courseId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
