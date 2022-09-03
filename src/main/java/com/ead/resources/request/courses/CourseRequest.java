package com.ead.resources.request.courses;

import com.ead.enums.CourseLevelE;
import com.ead.enums.CourseStatusE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private String imageUrl;

    @NotNull
    private CourseStatusE statusE;

    @NotNull
    private CourseLevelE levelE;

    @NotNull
    private UUID userInstructorId;
}
