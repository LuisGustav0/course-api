package com.ead.specifications;

import com.ead.model.CourseModel;
import com.ead.model.ModuleModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.UUID;

public class ModuleSpec {

    public static Specification<ModuleModel> withByCourseId(final UUID courseId) {
        return ((root, query, builder) -> {
            query.distinct(true);

            Root<CourseModel> courseRoot = query.from(CourseModel.class);

            Expression<Collection<ModuleModel>> courseAndModule = courseRoot.get("listModules");

            return builder.and(
                    builder.equal(courseRoot.get("id"), courseId),
                    builder.isMember(root, courseAndModule)
            );
        });
    }

    public static Specification<ModuleModel> withTitleLike(final String title) {
        return ((root, query, builder) -> {
            if (StringUtils.isEmpty(title))
                return builder.conjunction();

            return builder.like(
                    builder.lower(root.get("title")),
                    builder.lower(builder.literal("%" + title + "%"))
            );
        });
    }
}
