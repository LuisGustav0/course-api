package com.ead.services.lessons;

import com.ead.model.LessonModel;
import com.ead.model.ModuleModel;
import com.ead.repositories.LessonRepository;
import com.ead.assembler.lessons.LessonRequestAssembler;
import com.ead.assembler.lessons.LessonResponseAssembler;
import com.ead.model.request.lessons.LessonRequest;
import com.ead.model.response.lessons.LessonResponse;
import com.ead.services.modules.FindModuleByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateLessonService {

    private final LessonRepository repository;

    private final LessonRequestAssembler requestAssembler;
    private final LessonResponseAssembler responseAssembler;

    private final FindModuleByIdService findModuleByIdService;

    public LessonResponse call(final UUID moduleId, final LessonRequest request) {
        final ModuleModel module = findModuleByIdService.call(moduleId);

        final LessonModel lesson = this.requestAssembler.toModel(module, request);

        final LessonModel lessonSave = this.repository.save(lesson);

        return this.responseAssembler.toResponse(lessonSave);
    }
}
