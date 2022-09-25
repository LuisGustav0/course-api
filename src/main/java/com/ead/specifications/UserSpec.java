package com.ead.specifications;

import com.ead.model.CourseModel;
import com.ead.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.UUID;

public class UserSpec {

    private UserSpec() {
    }

    public static Specification<UserModel> withFullNameLike(final String fullName) {
        return ((root, query, builder) -> {
            if (StringUtils.isEmpty(fullName))
                return builder.conjunction();

            return builder.like(
                    builder.lower(root.get("fullName")),
                    builder.lower(builder.literal("%" + fullName + "%"))
            );
        });
    }

    public static Specification<UserModel> withCourseIdEquals(final UUID courseId) {
        return ((root, query, builder) -> {
            if (courseId == null)
                return builder.conjunction();

            query.distinct(true);

            Root<CourseModel> user = query.from(CourseModel.class);

            Expression<Collection<UserModel>> coursesUsers = user.get("listUser");

            return builder.and(builder.equal(user.get("id"), courseId), builder.isMember(root, coursesUsers));
        });
    }
}
