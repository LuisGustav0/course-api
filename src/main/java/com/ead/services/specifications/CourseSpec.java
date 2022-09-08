package com.ead.services.specifications;

import com.ead.enums.CourseLevelE;
import com.ead.enums.CourseStatusE;
import com.ead.model.CourseModel;
import com.ead.model.CourseUserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import java.util.UUID;

public class CourseSpec {

    public static Specification<CourseModel> withNameLike(final String name) {
        return ((root, query, builder) -> {
            if (StringUtils.isEmpty(name))
                return builder.conjunction();

            return builder.like(
                    builder.lower(root.get("name")),
                    builder.lower(builder.literal("%" + name + "%"))
            );
        });
    }

    public static Specification<CourseModel> withStatusEquals(final CourseStatusE statusE) {
        return ((root, query, builder) -> {
            if (statusE == null)
                return builder.conjunction();

            return builder.equal(root.get("statusE"), statusE);
        });
    }

    public static Specification<CourseModel> withLevelEquals(final CourseLevelE levelE) {
        return ((root, query, builder) -> {
            if (levelE == null)
                return builder.conjunction();

            return builder.equal(root.get("levelE"), levelE);
        });
    }

    public static Specification<CourseModel> withUserUserId(final UUID userId) {
        return ((root, query, builder) -> {
            if (userId == null)
                return builder.conjunction();

            query.distinct(true);

            Join<CourseModel, CourseUserModel> userJoin = root.join("listUser");

            return builder.equal(userJoin.get("userId"), userId);
        });
    }
}
