package com.ead.resources;

import com.ead.resources.response.courses.DeleteCourseByIdResponse;
import com.ead.services.DeleteCourseByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DeleteCourseByIdResource {

    private final DeleteCourseByIdService service;

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<DeleteCourseByIdResponse> call(@PathVariable UUID id) {
        final DeleteCourseByIdResponse response = this.service.call(id);

        return ResponseEntity.ok(response);
    }
}
