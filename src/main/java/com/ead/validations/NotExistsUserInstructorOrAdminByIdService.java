package com.ead.validations;

import com.ead.enums.UserTypeE;
import com.ead.exceptions.UserInstructorOrAdminNotFoundException;
import com.ead.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotExistsUserInstructorOrAdminByIdService {

    private final UserRepository repository;

    public void call(final UUID id) {
        if (this.repository.isNotExistsTypeInstructorOrAdminById(id))
            throw new UserInstructorOrAdminNotFoundException();
    }
}
