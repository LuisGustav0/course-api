package com.ead.model.request.lessons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequest {

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    private String videoUrl;
}
