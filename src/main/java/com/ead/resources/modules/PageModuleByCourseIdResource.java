package com.ead.resources.modules;

import com.ead.resources.response.modules.PageModuleResponse;
import com.ead.services.modules.PageModuleByCourseIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PageModuleByCourseIdResource {

    private final PageModuleByCourseIdService service;

    @GetMapping("/courses/{courseId}/modules")
    public ResponseEntity<PageModuleResponse> call(@PathVariable UUID courseId) {
        final PageModuleResponse response = this.service.call(courseId);

        return ResponseEntity.ok(response);
    }
}
