package com.ead.services.lessons;

import com.ead.model.LessonModel;
import com.ead.repositories.LessonRepository;
import com.ead.assembler.lessons.LessonRequestAssembler;
import com.ead.assembler.lessons.LessonResponseAssembler;
import com.ead.model.request.lessons.LessonRequest;
import com.ead.model.response.lessons.LessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateLessonService {

    private final LessonRepository repository;

    private final LessonRequestAssembler requestAssembler;
    private final LessonResponseAssembler responseAssembler;

    private final LessonByIdAndModuleIdOrElseThrowService findByIdAndModuleIdService;

    public LessonResponse call(final UUID id,
                               final UUID moduleId,
                               final LessonRequest request) {
        final LessonModel lesson = this.findByIdAndModuleIdService.call(id, moduleId);

        this.requestAssembler.copyProperties(request, lesson);

        final LessonModel lessonSave = this.repository.save(lesson);

        return this.responseAssembler.toResponse(lessonSave);
    }
}
