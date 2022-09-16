package com.ead.services.users;

import com.ead.clients.authuserapi.DeleteUserCourseByCourseIdClientApi;
import com.ead.clients.authuserapi.UserByIdOrElseThrowClientApi;
import com.ead.exceptions.UserBlockedException;
import com.ead.exceptions.UserNotFoundException;
import com.ead.model.response.users.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCourseInAuthUserService {

    private final DeleteUserCourseByCourseIdClientApi userClientApi;

    public void call(final UUID courseId) {

    }
}
