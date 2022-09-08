package com.ead.resources;

import com.ead.resources.request.courses.CourseRequest;
import com.ead.resources.response.courses.CourseResponse;
import com.ead.services.UpdateCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UpdateCourseResource {

    private final UpdateCourseService service;

    @PutMapping("/courses/{id}")
    public ResponseEntity<CourseResponse> call(@PathVariable UUID id,
                                                     @RequestBody @Valid CourseRequest request) {
        final CourseResponse response = this.service.call(id, request);

        return ResponseEntity.ok(response);
    }
}
