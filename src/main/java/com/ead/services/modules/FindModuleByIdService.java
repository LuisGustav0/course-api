package com.ead.services.modules;

import com.ead.exceptions.ModuleNotFoundException;
import com.ead.model.ModuleModel;
import com.ead.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindModuleByIdService {

    private final ModuleRepository repository;

    public ModuleModel call(final UUID id) {
        return this.repository.findById(id).orElseThrow(ModuleNotFoundException::new);
    }
}
