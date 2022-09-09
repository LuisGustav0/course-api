package com.ead.model.response.courseuser;

import com.ead.model.response.users.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageableCourseUserResponse {

    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalElements;

    private List<UserResponse> data;
}
