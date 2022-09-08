package com.ead.services.lessons;

import com.ead.exceptions.LessonNotFoundException;
import com.ead.model.LessonModel;
import com.ead.repositories.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonByIdAndModuleIdOrElseThrowService {

    private final LessonRepository repository;

    public LessonModel call(final UUID id, final UUID moduleId) {
        return this.repository.findByIdAndModuleId(id, moduleId)
                              .orElseThrow(LessonNotFoundException::new);
    }
}
