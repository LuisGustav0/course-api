package com.ead.services.courses;

import com.ead.model.CourseModel;
import com.ead.resources.assembler.courses.response.CourseResponseAssembler;
import com.ead.resources.response.courses.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindCourseByIdService {

    private final CourseResponseAssembler assembler;
    private final FindCourseByIdOrElseThrowService findByIdOrElseThrowService;

    public CourseResponse call(final UUID id) {
        final CourseModel course = this.findByIdOrElseThrowService.call(id);

        return this.assembler.toResponse(course);
    }
}
