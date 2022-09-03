package com.ead.services.modules;

import com.ead.model.ModuleModel;
import com.ead.repositories.ModuleRepository;
import com.ead.resources.assembler.modules.request.UpdateModuleRequestAssembler;
import com.ead.resources.assembler.modules.response.UpdateModuleResponseAssembler;
import com.ead.resources.request.modules.UpdateModuleRequest;
import com.ead.resources.response.modules.UpdateModuleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateModuleService {

    private final ModuleRepository repository;

    private final UpdateModuleRequestAssembler requestAssembler;
    private final UpdateModuleResponseAssembler responseAssembler;

    private final FindModuleByIdAndCourseIdOrElseThrowService findByIdAndCourseIdOrElseThrowService;

    public UpdateModuleResponse call(final UUID id,
                                     final UUID courseId,
                                     final UpdateModuleRequest request) {
        final ModuleModel module = this.findByIdAndCourseIdOrElseThrowService.call(id, courseId);

        this.requestAssembler.copyProperties(module, request);

        final ModuleModel moduleSave = this.repository.save(module);

        return this.responseAssembler.toResponse(moduleSave);
    }
}
