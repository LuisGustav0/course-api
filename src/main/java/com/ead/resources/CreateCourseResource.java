package com.ead.resources;

import com.ead.model.request.CourseRequest;
import com.ead.model.response.CourseResponse;
import com.ead.services.CreateCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CreateCourseResource {

    private final CreateCourseService service;

    @PostMapping("/courses")
    @PreAuthorize("hasAnyRole('INSTRUCTOR')")
    public ResponseEntity<CourseResponse> call(@RequestBody @Valid CourseRequest request) {
        final CourseResponse response = this.service.call(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
