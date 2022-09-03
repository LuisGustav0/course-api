package com.ead.resources.assembler.courses.response;

import com.ead.model.CourseModel;
import com.ead.resources.response.courses.UpdateCourseResponse;
import org.springframework.stereotype.Component;

@Component
public class UpdateCourseResponseAssembler {

    public UpdateCourseResponse toResponse(final CourseModel course) {
        return UpdateCourseResponse.builder()
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
