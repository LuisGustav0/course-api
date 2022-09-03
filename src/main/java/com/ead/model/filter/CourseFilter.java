package com.ead.model.filter;

import com.ead.enums.CourseLevelE;
import com.ead.enums.CourseStatusE;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
@NoArgsConstructor
public class CourseFilter {

    private String name;

    private CourseStatusE statusE;

    private CourseLevelE levelE;

    public boolean isNameNotEmpty() {
        return StringUtils.isNotEmpty(this.name);
    }

    public boolean isStatusNotNull() {
        return this.statusE != null;
    }

    public boolean isLevelNotNull() {
        return this.levelE != null;
    }
}
