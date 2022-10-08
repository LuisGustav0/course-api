package com.ead.services;

import com.ead.assembler.courses.CourseRequestAssembler;
import com.ead.assembler.courses.CourseResponseAssembler;
import com.ead.model.CourseModel;
import com.ead.model.request.CourseRequest;
import com.ead.model.response.CourseResponse;
import com.ead.repositories.CourseRepository;
import com.ead.services.users.CurrentUserIdDifferentUserIdService;
import com.ead.validations.NotExistsUserInstructorOrAdminByIdService;
import com.ead.validations.ExistsCourseByNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCourseService {

    private final CourseRepository repository;

    private final NotExistsUserInstructorOrAdminByIdService notExistsUserInstructorOrAdminByIdService;

    private final CourseRequestAssembler requestAssembler;
    private final CourseResponseAssembler responseAssembler;

    private final ExistsCourseByNameService existsCourseByNameService;

    private final CurrentUserIdDifferentUserIdService currentUserIdDifferentUserIdService;

    public CourseResponse call(final CourseRequest request) {
        this.existsCourseByNameService.call(request.getName());
        this.currentUserIdDifferentUserIdService.call(request.getUserInstructorId());
        this.notExistsUserInstructorOrAdminByIdService.call(request.getUserInstructorId());

        final CourseModel course = this.requestAssembler.toModel(request);

        final CourseModel courseSaved = this.repository.save(course);

        return this.responseAssembler.toResponse(courseSaved);
    }
}
