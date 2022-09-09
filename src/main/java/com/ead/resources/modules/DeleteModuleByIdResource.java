package com.ead.resources.modules;

import com.ead.model.response.modules.DeleteModuleByIdResponse;
import com.ead.services.modules.DeleteModuleByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DeleteModuleByIdResource {

    private final DeleteModuleByIdService service;

    @DeleteMapping("/courses/{courseId}/modules/{id}")
    public ResponseEntity<DeleteModuleByIdResponse> call(@PathVariable UUID id,
                                                         @PathVariable UUID courseId) {
        final DeleteModuleByIdResponse response = this.service.call(id, courseId);

        return ResponseEntity.ok(response);
    }
}
