package com.ead.resources.modules;

import com.ead.model.filter.ModuleFilter;
import com.ead.model.response.modules.PageModuleResponse;
import com.ead.services.modules.PageableModuleByCourseIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PageableModuleByCourseIdResource {

    private final PageableModuleByCourseIdService service;

    @PreAuthorize("hasAnyRole('STUDENT')")
    @GetMapping("/courses/{courseId}/modules")
    public ResponseEntity<PageModuleResponse> call(@PathVariable UUID courseId,
                                                   final ModuleFilter filter,
                                                   final Pageable pageable) {
        final PageModuleResponse response = this.service.call(courseId, filter, pageable);

        return ResponseEntity.ok(response);
    }
}
