package com.ead.services.lessons;

import com.ead.model.LessonModel;
import com.ead.resources.assembler.lessons.response.LessonResponseAssembler;
import com.ead.resources.response.lessons.LessonResponse;
import com.ead.resources.response.lessons.PageLessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PageLessonService {

    private final LessonResponseAssembler responseAssembler;

    private final FindAllLessonByModuleIdService findAllByModuleIdService;

    public PageLessonResponse call(final UUID moduleId) {
        final List<LessonModel> listLesson = this.findAllByModuleIdService.call(moduleId);

        final List<LessonResponse> data = this.responseAssembler.toListResponse(listLesson);

        return PageLessonResponse.builder()
                                 .data(data)
                                 .build();
    }
}
