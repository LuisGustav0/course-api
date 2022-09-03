package com.ead.resources.assembler.courses.response;

import com.ead.model.CourseModel;
import com.ead.resources.response.courses.CreateCourseResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateCourseResponseAssembler {

    public CreateCourseResponse toResponse(final CourseModel course) {
        return CreateCourseResponse.builder()
                                   .id(course.getId())
                                   .name(course.getName())
                                   .description(course.getDescription())
                                   .statusE(course.getStatusE())
                                   .levelE(course.getLevelE())
                                   .userInstructorId(course.getUserInstructorId())
                                   .createdAt(course.getCreatedAt())
                                   .updatedAt(course.getUpdatedAt())
                                   .build();
    }
}
