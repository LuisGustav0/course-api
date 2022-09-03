package com.ead.resources.assembler.modules.response;

import com.ead.model.ModuleModel;
import com.ead.resources.response.modules.CreateModuleResponse;
import com.ead.resources.response.modules.UpdateModuleResponse;
import org.springframework.stereotype.Component;

@Component
public class UpdateModuleResponseAssembler {

    public UpdateModuleResponse toResponse(final ModuleModel module) {
        return UpdateModuleResponse.builder()
                                   .id(module.getId())
                                   .title(module.getTitle())
                                   .description(module.getDescription())
                                   .build();
    }
}
