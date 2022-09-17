package com.ead.services.courseuser;

import com.ead.model.response.courseuser.DeleteCourseUserResponse;
import com.ead.model.response.users.UserResponse;
import com.ead.repositories.CourseUserRepository;
import com.ead.services.users.UserByIdOrElseThrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCourseUserByUserIdService {

    private final CourseUserRepository repository;

    private final UserByIdOrElseThrowService userByIdOrElseThrowService;

    public DeleteCourseUserResponse call(final UUID userId) {
        final UserResponse user = userByIdOrElseThrowService.call(userId);

        this.repository.deleteByUserId(user.getId());

        return DeleteCourseUserResponse.builder()
                                       .message("Curso do usuario deletado com sucesso!")
                                       .build();
    }
}