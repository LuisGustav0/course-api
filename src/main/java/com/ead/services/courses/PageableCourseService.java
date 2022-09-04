package com.ead.services.courses;

import com.ead.model.CourseModel;
import com.ead.model.filter.CourseFilter;
import com.ead.repositories.CourseRepository;
import com.ead.resources.assembler.courses.response.CourseResponseAssembler;
import com.ead.resources.response.courses.CourseResponse;
import com.ead.resources.response.courses.PageCourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ead.services.specifications.CourseSpec.withLevelEquals;
import static com.ead.services.specifications.CourseSpec.withNameLike;
import static com.ead.services.specifications.CourseSpec.withStatusEquals;

@Service
@RequiredArgsConstructor
public class PageableCourseService {

    private final CourseRepository repository;

    private final CourseResponseAssembler assembler;

    private Specification<CourseModel> getSpecification(final CourseFilter filter) {
        return withNameLike(filter.getName())
                .and(withStatusEquals(filter.getStatusE()))
                .and(withLevelEquals(filter.getLevelE()));
    }

    public PageCourseResponse call(final CourseFilter filter,
                                   @PageableDefault(
                                           sort = "id",
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
