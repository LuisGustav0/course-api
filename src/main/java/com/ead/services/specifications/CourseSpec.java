package com.ead.services.specifications;

import com.ead.enums.CourseLevelE;
import com.ead.enums.CourseStatusE;
import com.ead.model.CourseModel;
import org.springframework.data.jpa.domain.Specification;

public class CourseSpec {

    public static Specification<CourseModel> withNameLike(final String name) {
        return ((root, query, builder) -> builder.like(
                builder.lower(root.get("name")),
                builder.lower(builder.literal("%" + name + "%"))
        ));
    }

    public static Specification<CourseModel> withStatusEquals(final CourseStatusE statusE) {
        return ((root, query, builder) -> builder.equal(root.get("statusE"), statusE));
    }

    public static Specification<CourseModel> withLevelEquals(final CourseLevelE levelE) {
        return ((root, query, builder) -> builder.equal(root.get("levelE"), levelE));
    }
}
