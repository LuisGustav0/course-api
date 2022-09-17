package com.ead.resources.courseuser;

import com.ead.model.response.courseuser.DeleteCourseUserResponse;
import com.ead.services.courseuser.DeleteCourseUserByUserIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DeleteCourseUserByUserIdResource {

    private final DeleteCourseUserByUserIdService service;

    @DeleteMapping("/courses/users/{userId}")
    public ResponseEntity<DeleteCourseUserResponse> call(@PathVariable UUID userId) {
        final DeleteCourseUserResponse response = this.service.call(userId);

        return ResponseEntity.ok(response);
    }
}
