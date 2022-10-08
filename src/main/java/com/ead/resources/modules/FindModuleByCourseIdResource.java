package com.ead.resources.modules;

import com.ead.model.response.modules.ModuleResponse;
import com.ead.services.modules.ModuleByCourseIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FindModuleByCourseIdResource {

    private final ModuleByCourseIdService service;

    @PreAuthorize("hasAnyRole('STUDENT')")
    @GetMapping("/courses/{courseId}/modules/{id}")
    public ResponseEntity<ModuleResponse> call(@PathVariable UUID id,
                                               @PathVariable UUID courseId) {
        final ModuleResponse response = this.service.call(id, courseId);

        return ResponseEntity.ok(response);
    }
}
