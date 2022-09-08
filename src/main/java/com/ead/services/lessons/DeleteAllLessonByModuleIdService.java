package com.ead.services.lessons;

import com.ead.model.LessonModel;
import com.ead.repositories.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteAllLessonByModuleIdService {

    private final LessonRepository repository;
    private final FindAllLessonByModuleIdService allLessonByModuleIdService;

    public void call(final UUID moduleId) {
        final List<LessonModel> listLesson = this.allLessonByModuleIdService.call(moduleId);

        if (listLesson.isEmpty())
            return;

       this.repository.deleteAll(listLesson);
    }
}
