package com.ead.resources.courses;

import com.ead.resources.response.courses.CourseResponse;
import com.ead.services.courses.FindCourseByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FindCourseByIdResource {

    private final FindCourseByIdService service;

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseResponse> call(@PathVariable UUID id) {
        final CourseResponse response = this.service.call(id);

        return ResponseEntity.ok(response);
    }
}
