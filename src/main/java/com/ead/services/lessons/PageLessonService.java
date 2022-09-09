package com.ead.services.lessons;

import com.ead.model.LessonModel;
import com.ead.model.filter.LessonFilter;
import com.ead.repositories.LessonRepository;
import com.ead.assembler.lessons.response.LessonResponseAssembler;
import com.ead.resources.response.lessons.LessonResponse;
import com.ead.resources.response.lessons.PageLessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.ead.services.specifications.LessonSpec.withByModuleId;
import static com.ead.services.specifications.LessonSpec.withTitleLike;


@Service
@RequiredArgsConstructor
public class PageLessonService {

    private final LessonRepository repository;

    private final LessonResponseAssembler responseAssembler;

    private Specification<LessonModel> getSpecification(final UUID moduleId,
                                                        final LessonFilter filter) {
        return withByModuleId(moduleId).and(withTitleLike(filter.getTitle()));
    }

    public PageLessonResponse call(final UUID moduleId,
                                   final LessonFilter filter,
                                   @PageableDefault(
                                           sort = "createdAt",
                                           direction = Sort.Direction.DESC
                                   ) final Pageable pageable) {
        final Specification<LessonModel> spec = getSpecification(moduleId, filter);

        final Page<LessonModel> pageLesson = this.repository.findAll(spec, pageable);

        final List<LessonResponse> data = this.responseAssembler.toListResponse(pageLesson.getContent());

        final int pageNumber = pageLesson.getPageable().getPageNumber();
        final int pageSize = pageLesson.getPageable().getPageSize();
        final int totalPages = pageLesson.getTotalPages();
        final long totalElements = pageLesson.getTotalElements();

        return PageLessonResponse.builder()
                                 .data(data)
                                 .pageNumber(pageNumber)
                                 .pageSize(pageSize)
                                 .totalPages(totalPages)
                                 .totalElements(totalElements)
                                 .build();
    }
}
