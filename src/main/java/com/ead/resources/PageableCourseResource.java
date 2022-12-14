package com.ead.resources;

import com.ead.model.filter.CourseFilter;
import com.ead.model.response.PageCourseResponse;
import com.ead.services.PageableCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PageableCourseResource {

    private final PageableCourseService service;

    @GetMapping("/courses")
    @PreAuthorize("hasAnyRole('STUDENT')")
    public ResponseEntity<PageCourseResponse> call(final CourseFilter filter,
                                                   final Pageable pageable) {
        final PageCourseResponse response = this.service.call(filter, pageable);

        return ResponseEntity.ok(response);
    }
}
