package com.ead.services.modules;

import com.ead.model.ModuleModel;
import com.ead.repositories.ModuleRepository;
import com.ead.resources.assembler.modules.response.ModuleResponseAssembler;
import com.ead.resources.response.modules.ModuleResponse;
import com.ead.resources.response.modules.PageModuleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PageModuleByCourseIdService {

    private final ModuleRepository repository;

    private final ModuleResponseAssembler assembler;

    public PageModuleResponse call(final UUID courseId) {
        final List<ModuleModel> listModule = this.repository.findAllByCourseId(courseId);

        final List<ModuleResponse> data = this.assembler.toListResponse(listModule);

        return PageModuleResponse.builder()
                                 .data(data)
                                 .build();
    }
}
