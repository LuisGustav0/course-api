package com.ead.resources.courses;

import com.ead.resources.request.courses.UpdateCourseRequest;
import com.ead.resources.response.courses.UpdateCourseResponse;
import com.ead.services.courses.UpdateCourseService;
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
    public ResponseEntity<UpdateCourseResponse> call(@PathVariable UUID id,
                                                     @RequestBody @Valid UpdateCourseRequest request) {
        final UpdateCourseResponse response = this.service.call(id, request);

        return ResponseEntity.ok(response);
    }
}
