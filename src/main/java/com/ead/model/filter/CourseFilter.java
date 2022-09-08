package com.ead.model.filter;

import com.ead.enums.CourseLevelE;
import com.ead.enums.CourseStatusE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseFilter {

    private String name;

    private CourseStatusE statusE;

    private CourseLevelE levelE;

    private UUID userId;
}
