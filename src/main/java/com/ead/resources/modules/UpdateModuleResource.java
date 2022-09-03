package com.ead.resources.modules;

import com.ead.resources.request.modules.UpdateModuleRequest;
import com.ead.resources.response.modules.UpdateModuleResponse;
import com.ead.services.modules.UpdateModuleService;
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
public class UpdateModuleResource {

    private final UpdateModuleService service;

    @PutMapping("/courses/{courseId}/modules/{id}")
    public ResponseEntity<UpdateModuleResponse> call(@PathVariable UUID id,
                                                     @PathVariable UUID courseId,
                                                     @RequestBody @Valid UpdateModuleRequest request) {
        final UpdateModuleResponse response = this.service.call(id, courseId, request);

        return ResponseEntity.ok(response);
    }
}
