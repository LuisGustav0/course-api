package com.ead.assembler.courses;

import com.ead.model.CourseModel;
import com.ead.model.request.CourseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseRequestAssembler {

    public CourseModel toModel(final CourseRequest request) {
        return CourseModel.builder()
                          .name(request.getName())
                          .description(request.getDescription())
                          .imageUrl(request.getImageUrl())
                          .statusE(request.getStatusE())
                          .levelE(request.getLevelE())
                          .userInstructorId(request.getUserInstructorId())
                          .build();
    }

    public void copyProperties(final CourseRequest source, final CourseModel target) {
        target.setDescription(source.getDescription());
        target.setName(source.getName());
        target.setStatusE(source.getStatusE());
        target.setLevelE(source.getLevelE());
        target.setUserInstructorId(source.getUserInstructorId());
    }
}
