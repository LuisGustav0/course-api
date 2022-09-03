package com.ead.resources.lessons;

import com.ead.resources.response.lessons.LessonResponse;
import com.ead.services.lessons.FindLessonByIdAndModuleIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FindLessonByIdAndModuleIdResource {

    private final FindLessonByIdAndModuleIdService service;

    @GetMapping("/modules/{moduleId}/lessons/{id}")
    public ResponseEntity<LessonResponse> call(@PathVariable UUID id,
                                               @PathVariable UUID moduleId) {
        final LessonResponse response = this.service.call(id, moduleId);

        return ResponseEntity.ok(response);
    }
}
