package com.ead.resources.assembler.modules.response;

import com.ead.model.ModuleModel;
import com.ead.resources.response.modules.ModuleResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModuleResponseAssembler {

    public ModuleResponse toResponse(final ModuleModel module) {
        return ModuleResponse.builder()
                             .id(module.getId())
                             .title(module.getTitle())
                             .description(module.getDescription())
                             .createdAt(module.getCreatedAt())
                             .updatedAt(module.getUpdatedAt())
                             .build();
    }

    public List<ModuleResponse> toListResponse(final List<ModuleModel> listModule) {
        return listModule.stream().map(this::toResponse).toList();
    }
}
