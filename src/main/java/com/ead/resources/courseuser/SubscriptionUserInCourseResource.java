package com.ead.resources.courseuser;

import com.ead.model.request.courseuser.SubscriptionUserInCourseRequest;
import com.ead.model.response.courseuser.SubscriptionUserInCourseResponse;
import com.ead.services.courseuser.SubscriptionUserInCourseService;
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
public class SubscriptionUserInCourseResource {

    private final SubscriptionUserInCourseService service;

    @PostMapping("/courses/{courseId}/users/subscription")
    public ResponseEntity<SubscriptionUserInCourseResponse> call(@PathVariable UUID courseId,
                                                                 @RequestBody @Valid SubscriptionUserInCourseRequest request) {
        final SubscriptionUserInCourseResponse response = this.service.call(courseId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
