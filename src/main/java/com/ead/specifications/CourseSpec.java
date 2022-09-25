package com.ead.specifications;

import com.ead.enums.CourseLevelE;
import com.ead.enums.CourseStatusE;
import com.ead.model.CourseModel;
import com.ead.model.UserModel;
import org.apache.commons.lang3.StringUtils;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.UUID;

public class CourseSpec {

    private CourseSpec() {
    }

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

    public static Specification<CourseModel> withUserIdEquals(final UUID userId) {
        return ((root, query, builder) -> {
            if (userId == null)
                return builder.conjunction();

            query.distinct(true);

            Root<UserModel> user = query.from(UserModel.class);

            Expression<Collection<CourseModel>> usersCourses = user.get("listCourse");

            return builder.and(builder.equal(user.get("id"), userId), builder.isMember(root, usersCourses));
        });
    }
}
