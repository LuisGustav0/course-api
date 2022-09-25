package com.ead.services.users;

import com.ead.model.UserModel;
import com.ead.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository repository;

    public void call(final UserModel user) {
        this.repository.save(user);
    }
}
