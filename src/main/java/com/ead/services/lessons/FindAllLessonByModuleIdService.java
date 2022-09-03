package com.ead.services.lessons;

import com.ead.model.LessonModel;
import com.ead.model.ModuleModel;
import com.ead.repositories.LessonRepository;
import com.ead.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindAllLessonByModuleIdService {

    private final LessonRepository repository;

    public List<LessonModel> call(final UUID moduleId) {
        return this.repository.findAllByModuleId(moduleId);
    }
}
