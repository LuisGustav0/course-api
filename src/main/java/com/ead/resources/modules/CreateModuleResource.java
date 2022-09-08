package com.ead.resources.modules;

import com.ead.resources.request.modules.ModuleRequest;
import com.ead.resources.response.modules.ModuleResponse;
import com.ead.services.modules.CreateModuleService;
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
public class CreateModuleResource {

    private final CreateModuleService service;

    @PostMapping("/courses/{courseId}/modules")
    public ResponseEntity<ModuleResponse> call(@PathVariable UUID courseId,
                                               @RequestBody @Valid ModuleRequest request) {
        final ModuleResponse response = this.service.call(courseId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}