package com.ead.assembler.modules.request;

import com.ead.model.CourseModel;
import com.ead.model.ModuleModel;
import com.ead.resources.request.modules.ModuleRequest;
import org.springframework.stereotype.Component;

@Component
public class ModuleRequestAssembler {

    public ModuleModel toModel(final CourseModel course, final ModuleRequest request) {
        return ModuleModel.builder()
                          .title(request.getTitle())
                          .description(request.getDescription())
                          .course(course)
                          .build();
    }

    public void copyProperties(final ModuleRequest source,
                               final ModuleModel target) {
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
    }
}
