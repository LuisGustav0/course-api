package com.ead.services.courseuser;

import com.ead.assembler.users.UserAssembler;
import com.ead.model.UserModel;
import com.ead.model.filter.UserFilter;
import com.ead.model.response.courseuser.PageableCourseUserResponse;
import com.ead.model.response.users.UserResponse;
import com.ead.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.ead.specifications.UserSpec.withCourseIdEquals;
import static com.ead.specifications.UserSpec.withFullNameLike;

@Log4j2
@Service
@RequiredArgsConstructor
public class PageableCourseUserService {

    private final UserRepository repository;

    private final UserAssembler assembler;

    private Specification<UserModel> getSpecification(final UUID courseId, final UserFilter filter) {
        return withFullNameLike(filter.getFullName()).and(withCourseIdEquals(courseId));
    }

    public PageableCourseUserResponse call(final UUID courseId,
                                           final UserFilter filter,
                                           final Pageable pageable) {
        final Specification<UserModel> spec = getSpecification(courseId, filter);

        final Page<UserModel> pageUser = this.repository.findAll(spec, pageable);

        final List<UserResponse> data = this.assembler.toListResponse(pageUser.getContent());

        final int pageNumber = pageUser.getPageable().getPageNumber();
        final int pageSize = pageUser.getPageable().getPageSize();
        final int totalPages = pageUser.getTotalPages();
        final long totalElements = pageUser.getTotalElements();

        return PageableCourseUserResponse.builder()
                                         .data(data)
                                         .pageNumber(pageNumber)
                                         .pageSize(pageSize)
                                         .totalPages(totalPages)
                                         .totalElements(totalElements)
                                         .build();
    }
}
