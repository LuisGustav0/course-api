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

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateCourseService {

    private final CourseRepository repository;

    private final CourseRequestAssembler requestAssembler;
    private final CourseResponseAssembler responseAssembler;

    private final ValidCourseByNameService validByNameService;

    private final CourseByIdOrElseThrowService findByIdOrElseThrowService;

    public CourseResponse call(final UUID id, final CourseRequest request) {
        final CourseModel course = this.findByIdOrElseThrowService.call(id);

        this.requestAssembler.copyProperties(request, course);

        this.validByNameService.callDifferentId(course.getName(), id);

        final CourseModel courseSaved = this.repository.save(course);

        return this.responseAssembler.toResponse(courseSaved);
    }
}
