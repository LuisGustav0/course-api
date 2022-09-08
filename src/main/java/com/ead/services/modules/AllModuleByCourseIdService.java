package com.ead.services.modules;

import com.ead.model.ModuleModel;
import com.ead.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AllModuleByCourseIdService {

    private final ModuleRepository repository;

    public List<ModuleModel> call(final UUID courseId) {
        return this.repository.findAllByCourseId(courseId);
    }
}
