package com.ead.assembler.users;

import com.ead.enums.UserStatusE;
import com.ead.model.UserModel;
import com.ead.model.response.users.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAssembler {

    public UserResponse toResponse(final UserModel user) {
        return UserResponse.builder()
                           .id(user.getId())
                           .fullName(user.getFullName())
                           .statusE(user.getStatusE())
                           .typeE(user.getTypeE())
                           .imageUrl(user.getImageUrl())
                           .createdAt(user.getCreatedAt().toString())
                           .updatedAt(user.getUpdatedAt().toString())
                           .build();
    }

    public List<UserResponse> toListResponse(final List<UserModel> listUser) {
        return listUser.stream().map(this::toResponse).toList();
    }
}
