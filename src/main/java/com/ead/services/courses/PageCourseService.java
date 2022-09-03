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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageCourseService {

    private final CourseRepository repository;

    private final CourseResponseAssembler assembler;

    public PageCourseResponse call(final CourseFilter filter, final Pageable pageable) {
        final Page<CourseModel> pageCourse = this.repository.findAll(pageable);

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
