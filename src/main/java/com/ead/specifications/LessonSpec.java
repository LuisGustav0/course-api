package com.ead.specifications;

import com.ead.model.LessonModel;
import com.ead.model.ModuleModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.UUID;

public class LessonSpec {

    private LessonSpec() {
    }

    public static Specification<LessonModel> withByModuleId(final UUID moduleId) {
        return ((root, query, builder) -> {
            query.distinct(true);

            Root<ModuleModel> moduleRoot = query.from(ModuleModel.class);

            Expression<Collection<LessonModel>> courseAndModule = moduleRoot.get("listLesson");

            return builder.and(
                    builder.equal(moduleRoot.get("id"), moduleId),
                    builder.isMember(root, courseAndModule)
            );
        });
    }

    public static Specification<LessonModel> withTitleLike(final String title) {
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
