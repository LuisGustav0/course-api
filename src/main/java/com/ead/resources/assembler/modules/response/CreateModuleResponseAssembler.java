package com.ead.resources.assembler.modules.response;

import com.ead.model.ModuleModel;
import com.ead.resources.response.modules.CreateModuleResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateModuleResponseAssembler {

    public CreateModuleResponse toResponse(final ModuleModel module) {
        return CreateModuleResponse.builder()
                                   .id(module.getId())
                                   .title(module.getTitle())
                                   .description(module.getDescription())
                                   .build();
    }
}
