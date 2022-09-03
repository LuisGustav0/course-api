package com.ead.resources.assembler.modules.request;

import com.ead.model.CourseModel;
import com.ead.model.ModuleModel;
import com.ead.resources.request.modules.CreateModuleRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateModuleRequestAssembler {

    public ModuleModel toModel(final CourseModel course, final CreateModuleRequest request) {
        return ModuleModel.builder()
                          .title(request.getTitle())
                          .description(request.getDescription())
                          .course(course)
                          .build();
    }
}
