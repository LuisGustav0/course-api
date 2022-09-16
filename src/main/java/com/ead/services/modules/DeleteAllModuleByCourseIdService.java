package com.ead.services.modules;

import com.ead.model.ModuleModel;
import com.ead.repositories.ModuleRepository;
import com.ead.services.lessons.DeleteAllLessonByModuleIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteAllModuleByCourseIdService {

    private final ModuleRepository repository;

    private final AllModuleByCourseIdService findAllModuleByCourseIdService;
    private final DeleteAllLessonByModuleIdService deleteAllLessonByModuleIdService;

    public boolean call(final UUID courseId) {
        final List<ModuleModel> listModule = this.findAllModuleByCourseIdService.call(courseId);

        if (listModule.isEmpty())
            return false;

        for (ModuleModel module : listModule) {
            this.deleteAllLessonByModuleIdService.call(module.getId());
        }

        this.repository.deleteAll(listModule);

        return true;
    }
}
