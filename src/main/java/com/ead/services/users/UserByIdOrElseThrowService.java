package com.ead.services.users;

import com.ead.exceptions.UserNotFoundException;
import com.ead.model.UserModel;
import com.ead.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserByIdOrElseThrowService {

    private final UserRepository repository;

    public UserModel call(UUID id) {
        return this.repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
