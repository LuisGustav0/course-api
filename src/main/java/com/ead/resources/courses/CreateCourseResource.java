package com.ead.resources.courses;

import com.ead.resources.request.courses.CreateCourseRequest;
import com.ead.resources.response.courses.CreateCourseResponse;
import com.ead.services.courses.CreateCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CreateCourseResource {

    private final CreateCourseService service;

    @PostMapping("/courses")
    public ResponseEntity<CreateCourseResponse> call(@RequestBody @Valid CreateCourseRequest request) {
        final CreateCourseResponse response = this.service.call(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
