package com.ead.resources.modules;

import com.ead.resources.response.modules.ModuleResponse;
import com.ead.services.modules.FindModuleByCourseIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FindModuleByCourseIdResource {

    private final FindModuleByCourseIdService service;

    @GetMapping("/courses/{courseId}/modules/{id}")
    public ResponseEntity<ModuleResponse> call(@PathVariable UUID id,
                                               @PathVariable UUID courseId) {
        final ModuleResponse response = this.service.call(id, courseId);

        return ResponseEntity.ok(response);
    }
}
