package com.ead.services.modules;

import com.ead.model.ModuleModel;
import com.ead.assembler.modules.ModuleResponseAssembler;
import com.ead.model.response.modules.ModuleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ModuleByCourseIdService {

    private final ModuleResponseAssembler assembler;
    private final ModuleByIdAndCourseIdOrElseThrowService findByIdAndCourseIdOrElseThrowService;

    public ModuleResponse call(final UUID id, final UUID courseId) {
        final ModuleModel module = this.findByIdAndCourseIdOrElseThrowService.call(id, courseId);

        return this.assembler.toResponse(module);
    }
}
