package com.ead.model.response.lessons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonResponse {

    private UUID id;
    private String title;
    private String description;
    private String videoUrl;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
