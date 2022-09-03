package com.ead.resources.assembler.lessons.request;

import com.ead.model.LessonModel;
import com.ead.model.ModuleModel;
import com.ead.resources.request.lessons.LessonRequest;
import org.springframework.stereotype.Component;

@Component
public class LessonRequestAssembler {

    public LessonModel toModel(final ModuleModel module, final LessonRequest request) {
        return LessonModel.builder()
                          .title(request.getTitle())
                          .description(request.getDescription())
                          .module(module)
                          .build();
    }

    public void copyProperties(final LessonRequest source, final LessonModel target) {
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setVideoUrl(source.getVideoUrl());
    }
}
