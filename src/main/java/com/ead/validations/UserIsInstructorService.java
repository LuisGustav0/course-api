package com.ead.validations;

import com.ead.exceptions.UserMustBeInstructorOrAdminException;
import com.ead.model.response.users.UserResponse;
import com.ead.services.users.UserByIdOrElseThrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserIsInstructorService {

    private final UserByIdOrElseThrowService userByIdOrElseThrowService;

    public void call(final UUID userInstructorId) {
        final UserResponse user = this.userByIdOrElseThrowService.call(userInstructorId);

        if (user.isTypeDifferentInstructor())
            throw new UserMustBeInstructorOrAdminException();
    }
}
