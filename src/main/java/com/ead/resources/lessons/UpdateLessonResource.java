package com.ead.resources.lessons;

import com.ead.resources.request.lessons.LessonRequest;
import com.ead.resources.response.lessons.LessonResponse;
import com.ead.services.lessons.UpdateLessonService;
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
public class UpdateLessonResource {

    private final UpdateLessonService service;

    @PutMapping("/modules/{moduleId}/lessons/{id}")
    public ResponseEntity<LessonResponse> call(@PathVariable UUID id,
                                               @PathVariable UUID moduleId,
                                               @RequestBody @Valid LessonRequest request) {
        final LessonResponse response = this.service.call(id, moduleId, request);

        return ResponseEntity.ok(response);
    }
}