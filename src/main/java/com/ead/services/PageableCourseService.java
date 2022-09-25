package com.ead.services;

import com.ead.assembler.courses.CourseResponseAssembler;
import com.ead.model.CourseModel;
import com.ead.model.filter.CourseFilter;
import com.ead.model.response.CourseResponse;
import com.ead.model.response.PageCourseResponse;
import com.ead.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ead.specifications.CourseSpec.withLevelEquals;
import static com.ead.specifications.CourseSpec.withNameLike;
import static com.ead.specifications.CourseSpec.withStatusEquals;
import static com.ead.specifications.CourseSpec.withUserIdEquals;

@Service
@RequiredArgsConstructor
public class PageableCourseService {

    private final CourseRepository repository;

    private final CourseResponseAssembler assembler;

    private Specification<CourseModel> getSpecification(final CourseFilter filter) {
        return withNameLike(filter.getName())
                .and(withStatusEquals(filter.getStatusE()))
                .and(withLevelEquals(filter.getLevelE()))
                .and(withUserIdEquals(filter.getUserId()));
    }

    public PageCourseResponse call(final CourseFilter filter,
                                   @PageableDefault(
                                           sort = "createdAt",
                                           direction = Sort.Direction.DESC
                                   ) final Pageable pageable) {
        final Specification<CourseModel> spec = getSpecification(filter);

        final Page<CourseModel> pageCourse = this.repository.findAll(spec, pageable);

        final List<CourseResponse> data = this.assembler.toListResponse(pageCourse.getContent());

        final int pageNumber = pageCourse.getPageable().getPageNumber();
        final int pageSize = pageCourse.getPageable().getPageSize();
        final int totalPages = pageCourse.getTotalPages();
        final long totalElements = pageCourse.getTotalElements();

        return PageCourseResponse.builder()
                                 .data(data)
                                 .pageNumber(pageNumber)
                                 .pageSize(pageSize)
                                 .totalPages(totalPages)
                                 .totalElements(totalElements)
                                 .build();
    }
}
