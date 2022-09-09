package com.ead.services;

import com.ead.model.CourseModel;
import com.ead.assembler.courses.response.CourseResponseAssembler;
import com.ead.resources.response.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseByIdService {

    private final CourseResponseAssembler assembler;
    private final CourseByIdOrElseThrowService findByIdOrElseThrowService;

    public CourseResponse call(final UUID id) {
        final CourseModel course = this.findByIdOrElseThrowService.call(id);

        return this.assembler.toResponse(course);
    }
}
