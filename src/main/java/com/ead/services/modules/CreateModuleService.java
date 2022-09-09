package com.ead.services.modules;

import com.ead.model.CourseModel;
import com.ead.model.ModuleModel;
import com.ead.repositories.ModuleRepository;
import com.ead.assembler.modules.ModuleRequestAssembler;
import com.ead.assembler.modules.ModuleResponseAssembler;
import com.ead.model.request.modules.ModuleRequest;
import com.ead.model.response.modules.ModuleResponse;
import com.ead.services.CourseByIdOrElseThrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateModuleService {

    private final ModuleRepository repository;

    private final ModuleRequestAssembler requestAssembler;
    private final ModuleResponseAssembler responseAssembler;

    private final CourseByIdOrElseThrowService findByIdOrElseThrowService;

    public ModuleResponse call(final UUID courseId,
                               final ModuleRequest request) {
        final CourseModel course = this.findByIdOrElseThrowService.call(courseId);

        final ModuleModel module = this.requestAssembler.toModel(course, request);

        final ModuleModel moduleSave = this.repository.save(module);

        return this.responseAssembler.toResponse(moduleSave);
    }
}
