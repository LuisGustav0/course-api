package com.ead.resources.courseuser;

import com.ead.model.filter.UserFilter;
import com.ead.model.response.courseuser.PageableCourseUserResponse;
import com.ead.services.courseuser.PageableCourseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class PageableCourseUserResource {

    private final PageableCourseUserService service;

    @PreAuthorize("hasAnyRole('INSTRUCTOR')")
    @GetMapping("/courses/{courseId}/users")
    public ResponseEntity<PageableCourseUserResponse> call(@PathVariable UUID courseId,
                                                           final UserFilter filter,
                                                           final @PageableDefault(
                                                                   sort = "createdAt",
                                                                   direction = Sort.Direction.DESC
                                                           ) Pageable pageable) {
        final PageableCourseUserResponse response = this.service.call(courseId, filter, pageable);

        return ResponseEntity.ok(response);
    }
}
