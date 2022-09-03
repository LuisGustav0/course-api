package com.ead.resources.assembler.courses.request;

import com.ead.model.CourseModel;
import com.ead.resources.request.courses.UpdateCourseRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateCourseRequestAssembler {

    public void copyProperties(final CourseModel course, final UpdateCourseRequest request) {
        course.setDescription(request.getDescription());
        course.setName(request.getName());
        course.setStatusE(request.getStatusE());
        course.setLevelE(request.getLevelE());
        course.setUserInstructorId(request.getUserInstructorId());
    }
}
