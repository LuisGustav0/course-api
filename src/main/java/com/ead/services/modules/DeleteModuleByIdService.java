package com.ead.services.modules;

import com.ead.model.ModuleModel;
import com.ead.repositories.ModuleRepository;
import com.ead.resources.response.modules.DeleteModuleByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteModuleByIdService {

    private final ModuleRepository repository;

    private final FindModuleByIdAndCourseIdOrElseThrowService findByIdAndCourseIdOrElseThrowService;

    public DeleteModuleByIdResponse call(final UUID id, final UUID courseId) {
        final ModuleModel module = this.findByIdAndCourseIdOrElseThrowService.call(id, courseId);

        this.repository.delete(module);

        return DeleteModuleByIdResponse.builder()
                                       .message("Modulo deletado com sucesso")
                                       .build();
    }
}
