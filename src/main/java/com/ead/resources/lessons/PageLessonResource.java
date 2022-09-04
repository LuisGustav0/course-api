package com.ead.resources.lessons;

import com.ead.model.filter.LessonFilter;
import com.ead.resources.response.lessons.PageLessonResponse;
import com.ead.services.lessons.PageLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PageLessonResource {

    private final PageLessonService service;

    @GetMapping("/modules/{moduleId}/lessons")
    public ResponseEntity<PageLessonResponse> call(@PathVariable UUID moduleId,
                                                   final LessonFilter filter,
                                                   final Pageable pageable) {
        final PageLessonResponse response = this.service.call(moduleId, filter, pageable);

        return ResponseEntity.ok(response);
    }
}
