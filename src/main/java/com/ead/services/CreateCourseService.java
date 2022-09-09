package com.ead.services;

import com.ead.model.CourseModel;
import com.ead.repositories.CourseRepository;
import com.ead.assembler.courses.request.CourseRequestAssembler;
import com.ead.assembler.courses.response.CourseResponseAssembler;
import com.ead.resources.request.courses.CourseRequest;
import com.ead.resources.response.CourseResponse;
import com.ead.validations.ValidCourseByNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCourseService {

    private final CourseRepository repository;

    private final CourseRequestAssembler requestAssembler;
    private final CourseResponseAssembler responseAssembler;

    private final ValidCourseByNameService validByNameService;

    public CourseResponse call(final CourseRequest request) {
        this.validByNameService.call(request.getName());

        final CourseModel course = this.requestAssembler.toModel(request);

        final CourseModel courseSaved = this.repository.save(course);

        return this.responseAssembler.toResponse(courseSaved);
    }
}
