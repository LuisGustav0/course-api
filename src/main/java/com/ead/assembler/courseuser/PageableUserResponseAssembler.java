package com.ead.assembler.courseuser;

import com.ead.resources.response.courseuser.PageableCourseUserResponse;
import com.ead.resources.response.courseuser.PageableUserResponse;
import org.springframework.stereotype.Component;

@Component
public class PageableUserResponseAssembler {

    public PageableCourseUserResponse toResponse(PageableUserResponse response) {
        return PageableCourseUserResponse.builder()
                                         .pageNumber(response.getPageNumber())
                                         .pageSize(response.getPageSize())
                                         .totalPages(response.getTotalPages())
                                         .totalElements(response.getTotalElements())
                                         .data(response.getData())
                                         .build();
    }
}
