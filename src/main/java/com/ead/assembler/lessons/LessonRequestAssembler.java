package com.ead.assembler.lessons;

import com.ead.model.LessonModel;
import com.ead.model.ModuleModel;
import com.ead.model.request.lessons.LessonRequest;
import org.springframework.stereotype.Component;

@Component
public class LessonRequestAssembler {

    public LessonModel toModel(final ModuleModel module, final LessonRequest request) {
        return LessonModel.builder()
                          .title(request.getTitle())
                          .description(request.getDescription())
                          .videoUrl(request.getVideoUrl())
                          .module(module)
                          .build();
    }

    public void copyProperties(final LessonRequest source, final LessonModel target) {
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setVideoUrl(source.getVideoUrl());
    }
}
