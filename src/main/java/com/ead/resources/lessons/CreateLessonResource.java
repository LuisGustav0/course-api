package com.ead.resources.lessons;

import com.ead.model.request.lessons.LessonRequest;
import com.ead.model.response.lessons.LessonResponse;
import com.ead.services.lessons.CreateLessonService;
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
public class CreateLessonResource {

    private final CreateLessonService service;

    @PostMapping("/modules/{moduleId}/lessons")
    public ResponseEntity<LessonResponse> call(@PathVariable UUID moduleId,
                                               @RequestBody @Valid LessonRequest request) {
        final LessonResponse response = this.service.call(moduleId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
