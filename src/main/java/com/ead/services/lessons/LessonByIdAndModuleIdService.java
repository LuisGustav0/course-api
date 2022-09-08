package com.ead.services.lessons;

import com.ead.model.LessonModel;
import com.ead.resources.assembler.lessons.response.LessonResponseAssembler;
import com.ead.resources.response.lessons.LessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonByIdAndModuleIdService {

    private final LessonResponseAssembler responseAssembler;
    private final LessonByIdAndModuleIdOrElseThrowService findByIdAndModuleIdOrElseThrowService;

    public LessonResponse call(final UUID id, final UUID moduleId) {
        final LessonModel lesson = this.findByIdAndModuleIdOrElseThrowService.call(id, moduleId);

        return this.responseAssembler.toResponse(lesson);
    }
}
