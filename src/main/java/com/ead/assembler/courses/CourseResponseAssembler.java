package com.ead.assembler.courses;

import com.ead.model.CourseModel;
import com.ead.model.response.CourseResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseResponseAssembler {

    public CourseResponse toResponse(final CourseModel course) {
        return CourseResponse.builder()
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

    public List<CourseResponse> toListResponse(final List<CourseModel> list) {
        return list.stream().map(this::toResponse).toList();
    }
}
