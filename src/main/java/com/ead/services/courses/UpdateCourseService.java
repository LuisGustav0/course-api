package com.ead.services.courses;

import com.ead.model.CourseModel;
import com.ead.repositories.CourseRepository;
import com.ead.resources.assembler.courses.request.UpdateCourseRequestAssembler;
import com.ead.resources.assembler.courses.response.UpdateCourseResponseAssembler;
import com.ead.resources.request.courses.UpdateCourseRequest;
import com.ead.resources.response.courses.UpdateCourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateCourseService {

    private final CourseRepository repository;

    private final UpdateCourseRequestAssembler requestAssembler;
    private final UpdateCourseResponseAssembler responseAssembler;
    private final FindCourseByIdOrElseThrowService findByIdOrElseThrowService;

    public UpdateCourseResponse call(final UUID id, final UpdateCourseRequest request) {
        final CourseModel course = this.findByIdOrElseThrowService.call(id);

        this.requestAssembler.copyProperties(course, request);

        final CourseModel courseSaved = this.repository.save(course);

        return this.responseAssembler.toResponse(courseSaved);
    }
}
