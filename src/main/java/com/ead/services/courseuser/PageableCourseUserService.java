package com.ead.services.courseuser;

import com.ead.clients.PageableUserClientApi;
import com.ead.assembler.courseuser.PageableUserResponseAssembler;
import com.ead.resources.response.courseuser.PageableCourseUserResponse;
import com.ead.resources.response.courseuser.PageableUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PageableCourseUserService {

    private final PageableUserClientApi pageableUserClientApi;

    private final PageableUserResponseAssembler assembler;

    public PageableCourseUserResponse call(final UUID courseId,
                                           final Pageable pageable) {
        final PageableUserResponse response = this.pageableUserClientApi.call(courseId, pageable);

        return this.assembler.toResponse(response);
    }
}
