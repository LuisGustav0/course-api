package com.ead.assembler.lessons;

import com.ead.model.LessonModel;
import com.ead.model.response.lessons.LessonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LessonResponseAssembler {

    public LessonResponse toResponse(final LessonModel lesson) {
        return LessonResponse.builder()
                                   .id(lesson.getId())
                                   .title(lesson.getTitle())
                                   .description(lesson.getDescription())
                                   .videoUrl(lesson.getVideoUrl())
                                   .createdAt(lesson.getCreatedAt())
                                   .updatedAt(lesson.getUpdatedAt())
                                   .build();
    }

    public List<LessonResponse> toListResponse(final List<LessonModel> listLesson) {
        return listLesson.stream().map(this::toResponse).toList();
    }
}
