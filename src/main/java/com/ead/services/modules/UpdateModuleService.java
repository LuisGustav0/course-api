package com.ead.services.modules;

import com.ead.model.ModuleModel;
import com.ead.repositories.ModuleRepository;
import com.ead.assembler.modules.ModuleRequestAssembler;
import com.ead.assembler.modules.ModuleResponseAssembler;
import com.ead.model.request.modules.ModuleRequest;
import com.ead.model.response.modules.ModuleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateModuleService {

    private final ModuleRepository repository;

    private final ModuleRequestAssembler requestAssembler;
    private final ModuleResponseAssembler responseAssembler;

    private final ModuleByIdAndCourseIdOrElseThrowService findByIdAndCourseIdOrElseThrowService;

    public ModuleResponse call(final UUID id,
                               final UUID courseId,
                               final ModuleRequest request) {
        final ModuleModel module = this.findByIdAndCourseIdOrElseThrowService.call(id, courseId);

        this.requestAssembler.copyProperties(request, module);

        final ModuleModel moduleSave = this.repository.save(module);

        return this.responseAssembler.toResponse(moduleSave);
    }
}
