package com.ead.services.courses;

import com.ead.model.CourseModel;
import com.ead.repositories.CourseRepository;
import com.ead.resources.assembler.courses.request.CreateCourseRequestAssembler;
import com.ead.resources.assembler.courses.response.CreateCourseResponseAssembler;
import com.ead.resources.request.courses.CreateCourseRequest;
import com.ead.resources.response.courses.CreateCourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCourseService {

    private final CourseRepository repository;

    private final CreateCourseRequestAssembler requestAssembler;
    private final CreateCourseResponseAssembler responseAssembler;

    public CreateCourseResponse call(final CreateCourseRequest request) {
        final CourseModel course = this.requestAssembler.toModel(request);

        final CourseModel courseSaved = this.repository.save(course);

        return this.responseAssembler.toResponse(courseSaved);
    }
}
