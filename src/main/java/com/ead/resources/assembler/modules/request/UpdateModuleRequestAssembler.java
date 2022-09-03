package com.ead.resources.assembler.modules.request;

import com.ead.model.ModuleModel;
import com.ead.resources.request.modules.UpdateModuleRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateModuleRequestAssembler {

    public void copyProperties(final ModuleModel module,
                               final UpdateModuleRequest request) {
        module.setTitle(request.getTitle());
        module.setDescription(request.getDescription());
    }
}
