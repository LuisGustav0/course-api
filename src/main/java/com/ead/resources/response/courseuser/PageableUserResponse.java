package com.ead.resources.response.courseuser;

import com.ead.resources.response.users.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageableUserResponse {

    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalElements;

    private List<UserResponse> data;
}
