package com.ead.resources.assembler.courses.request;

import com.ead.model.CourseModel;
import com.ead.resources.request.courses.CreateCourseRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateCourseRequestAssembler {

    public CourseModel toModel(CreateCourseRequest request) {
        return CourseModel.builder()
                          .name(request.getName())
                          .description(request.getDescription())
                          .statusE(request.getStatusE())
                          .levelE(request.getLevelE())
                          .userInstructorId(request.getUserInstructorId())
                          .build();
    }
}
