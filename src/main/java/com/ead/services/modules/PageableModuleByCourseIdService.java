package com.ead.services.modules;

import com.ead.model.ModuleModel;
import com.ead.model.filter.ModuleFilter;
import com.ead.repositories.ModuleRepository;
import com.ead.resources.assembler.modules.response.ModuleResponseAssembler;
import com.ead.resources.response.modules.ModuleResponse;
import com.ead.resources.response.modules.PageModuleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.ead.services.specifications.ModuleSpec.withByCourseId;
import static com.ead.services.specifications.ModuleSpec.withTitleLike;

@Service
@RequiredArgsConstructor
public class PageableModuleByCourseIdService {

    private final ModuleRepository repository;

    private final ModuleResponseAssembler assembler;

    private Specification<ModuleModel> getSpecification(final UUID courseId,
                                                        final ModuleFilter filter) {
        return withByCourseId(courseId).and(withTitleLike(filter.getTitle()));
    }

    public PageModuleResponse call(final UUID courseId,
                                   final ModuleFilter filter,
                                   @PageableDefault(
                                           sort = "id",
                                           direction = Sort.Direction.DESC
                                   ) final Pageable pageable) {
        final Specification<ModuleModel> spec = getSpecification(courseId, filter);

        final Page<ModuleModel> pageModule = this.repository.findAll(spec, pageable);

        final List<ModuleResponse> data = this.assembler.toListResponse(pageModule.getContent());

        final int pageNumber = pageModule.getPageable().getPageNumber();
        final int pageSize = pageModule.getPageable().getPageSize();
        final int totalPages = pageModule.getTotalPages();
        final long totalElements = pageModule.getTotalElements();

        return PageModuleResponse.builder()
                                 .pageNumber(pageNumber)
                                 .pageSize(pageSize)
                                 .totalPages(totalPages)
                                 .totalElements(totalElements)
                                 .data(data)
                                 .build();
    }
}
