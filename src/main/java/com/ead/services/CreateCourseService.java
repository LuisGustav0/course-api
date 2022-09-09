package com.ead.services;

import com.ead.model.CourseModel;
import com.ead.repositories.CourseRepository;
import com.ead.assembler.courses.CourseRequestAssembler;
import com.ead.assembler.courses.CourseResponseAssembler;
import com.ead.model.request.CourseRequest;
import com.ead.model.response.CourseResponse;
import com.ead.validations.ExistsCourseByNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCourseService {

    private final CourseRepository repository;

    private final CourseRequestAssembler requestAssembler;
    private final CourseResponseAssembler responseAssembler;

    private final ExistsCourseByNameService existsCourseByNameService;

    public CourseResponse call(final CourseRequest request) {
        this.existsCourseByNameService.call(request.getName());

        final CourseModel course = this.requestAssembler.toModel(request);

        final CourseModel courseSaved = this.repository.save(course);

        return this.responseAssembler.toResponse(courseSaved);
    }
}
