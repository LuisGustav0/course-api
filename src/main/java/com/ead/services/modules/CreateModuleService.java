package com.ead.services.modules;

import com.ead.model.CourseModel;
import com.ead.model.ModuleModel;
import com.ead.repositories.ModuleRepository;
import com.ead.resources.assembler.modules.request.CreateModuleRequestAssembler;
import com.ead.resources.assembler.modules.response.CreateModuleResponseAssembler;
import com.ead.resources.request.modules.CreateModuleRequest;
import com.ead.resources.response.modules.CreateModuleResponse;
import com.ead.services.courses.FindCourseByIdOrElseThrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateModuleService {

    private final ModuleRepository repository;

    private final CreateModuleRequestAssembler requestAssembler;
    private final CreateModuleResponseAssembler responseAssembler;
    private final FindCourseByIdOrElseThrowService findByIdOrElseThrowService;

    public CreateModuleResponse call(final UUID courseId,
                                     final CreateModuleRequest request) {
        final CourseModel course = this.findByIdOrElseThrowService.call(courseId);

        final ModuleModel module = this.requestAssembler.toModel(course, request);

        final ModuleModel moduleSave = this.repository.save(module);

        return this.responseAssembler.toResponse(moduleSave);
    }
}
