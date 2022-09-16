package com.ead.services;

import com.ead.model.CourseModel;
import com.ead.repositories.CourseRepository;
import com.ead.model.response.DeleteCourseByIdResponse;
import com.ead.services.courseuser.DeleteAllCourseUserByCourseIdService;
import com.ead.services.modules.DeleteAllModuleByCourseIdService;
import com.ead.services.users.DeleteCourseInAuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCourseByIdService {

    private final CourseRepository repository;

    private final CourseByIdOrElseThrowService findByIdOrElseThrowService;
    private final DeleteAllModuleByCourseIdService deleteAllModuleByCourseIdService;
    private final DeleteAllCourseUserByCourseIdService deleteAllCourseUserByCourseIdService;

    private final DeleteCourseInAuthUserService deleteCourseInAuthUserService;

    @Transactional
    public DeleteCourseByIdResponse call(final UUID id) {
        final CourseModel course = this.findByIdOrElseThrowService.call(id);

        this.deleteAllModuleByCourseIdService.call(course.getId());
        boolean deleteCourseUserInAuthUser = this.deleteAllCourseUserByCourseIdService.call(course.getId());

        this.repository.delete(course);

        if (deleteCourseUserInAuthUser)
            this.deleteCourseInAuthUserService.call(id);

        return DeleteCourseByIdResponse.builder()
                                       .message("Curso deletado com sucesso")
                                       .build();
    }
}
