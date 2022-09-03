package com.ead.services.lessons;

import com.ead.model.LessonModel;
import com.ead.repositories.LessonRepository;
import com.ead.resources.response.lessons.DeleteLessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteLessonByIdAndModuleIdService {

    private final LessonRepository repository;

    private final FindLessonByIdAndModuleIdOrElseThrowService findByIdAndModuleIdService;

    public DeleteLessonResponse call(final UUID id, final UUID moduleId) {
        final LessonModel lesson = findByIdAndModuleIdService.call(id, moduleId);

        this.repository.delete(lesson);

        return DeleteLessonResponse.builder()
                                   .message("Lição do modulo deletado com suceso")
                                   .build();
    }
}
