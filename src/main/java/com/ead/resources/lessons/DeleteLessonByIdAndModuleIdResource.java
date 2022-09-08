package com.ead.resources.lessons;

import com.ead.resources.response.lessons.DeleteLessonResponse;
import com.ead.services.lessons.DeleteLessonByIdAndModuleIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DeleteLessonByIdAndModuleIdResource {

    private final DeleteLessonByIdAndModuleIdService service;

    @DeleteMapping("/modules/{moduleId}/lessons/{id}")
    public ResponseEntity<DeleteLessonResponse> call(@PathVariable UUID id,
                                                     @PathVariable UUID moduleId) {
        final DeleteLessonResponse response = this.service.call(id, moduleId);

        return ResponseEntity.ok(response);
    }
}