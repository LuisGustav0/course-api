package com.ead.services.users;

import com.ead.clients.authuserapi.UserByIdOrElseThrowClientApi;
import com.ead.exceptions.UserBlockedException;
import com.ead.exceptions.UserNotFoundException;
import com.ead.model.response.users.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserByIdOrElseThrowService {

    private final UserByIdOrElseThrowClientApi userByIdOrElseThrowClientApi;

    public UserResponse call(final UUID userId) {
        final UserResponse user = this.userByIdOrElseThrowClientApi.call(userId);

        if (user == null)
            throw new UserNotFoundException();

        if (user.isBlocked())
            throw new UserBlockedException();

        return user;
    }
}
