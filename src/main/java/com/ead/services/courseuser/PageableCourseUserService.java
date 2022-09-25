package com.ead.services.courseuser;

import com.ead.assembler.courseuser.PageableUserResponseAssembler;
import com.ead.model.response.courseuser.PageableCourseUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class PageableCourseUserService {

    private final PageableUserResponseAssembler assembler;

    public PageableCourseUserResponse call(final UUID courseId,
                                           final Pageable pageable) {
        log.info("PageableCourseUserService.call CouseId: {}, Page: {}", courseId, pageable.getPageNumber());

        return this.assembler.toResponse(null);
    }
}
