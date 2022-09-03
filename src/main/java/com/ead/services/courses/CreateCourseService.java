package com.ead.services.courses;

import com.ead.model.CourseModel;
import com.ead.repositories.CourseRepository;
import com.ead.resources.assembler.courses.request.CourseRequestAssembler;
import com.ead.resources.assembler.courses.response.CourseResponseAssembler;
import com.ead.resources.request.courses.CourseRequest;
import com.ead.resources.response.courses.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCourseService {

    private final CourseRepository repository;

    private final CourseRequestAssembler requestAssembler;
    private final CourseResponseAssembler responseAssembler;

    public CourseResponse call(final CourseRequest request) {
        final CourseModel course = this.requestAssembler.toModel(request);

        final CourseModel courseSaved = this.repository.save(course);

        return this.responseAssembler.toResponse(courseSaved);
    }
}
