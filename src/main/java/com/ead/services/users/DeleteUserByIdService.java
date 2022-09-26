package com.ead.services.users;

import com.ead.repositories.UserRepository;
import com.ead.services.courseuser.DeleteCourseAndUserByUserIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserByIdService {

    private final UserRepository repository;

    private final DeleteCourseAndUserByUserIdService deleteCourseAndUserByUserIdService;

    @Transactional
    public void call(final UUID id) {
        this.deleteCourseAndUserByUserIdService.call(id);

        this.repository.deleteById(id);
    }
}
