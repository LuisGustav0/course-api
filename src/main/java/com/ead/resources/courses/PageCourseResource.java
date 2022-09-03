package com.ead.resources.courses;

import com.ead.model.filter.CourseFilter;
import com.ead.resources.response.courses.PageCourseResponse;
import com.ead.services.courses.PageCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PageCourseResource {

    private final PageCourseService service;

    @GetMapping("/courses")
    public ResponseEntity<PageCourseResponse> call(final CourseFilter filter, final Pageable pageable) {
        final PageCourseResponse response = this.service.call(filter, pageable);

        return ResponseEntity.ok(response);
    }
}
