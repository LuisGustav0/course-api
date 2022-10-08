package com.ead.resources.modules;

import com.ead.model.request.modules.ModuleRequest;
import com.ead.model.response.modules.ModuleResponse;
import com.ead.services.modules.UpdateModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UpdateModuleResource {

    private final UpdateModuleService service;

    @PreAuthorize("hasAnyRole('INSTRUCTOR')")
    @PutMapping("/courses/{courseId}/modules/{id}")
    public ResponseEntity<ModuleResponse> call(@PathVariable UUID id,
                                               @PathVariable UUID courseId,
                                               @RequestBody @Valid ModuleRequest request) {
        final ModuleResponse response = this.service.call(id, courseId, request);

        return ResponseEntity.ok(response);
    }
}
