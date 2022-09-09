package com.ead.model.response.users;

import com.ead.enums.UserStatusE;
import com.ead.enums.UserTypeE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private UUID id;
    private String login;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String cpf;
    private UserStatusE statusE;
    private UserTypeE typeE;
    private String imageUrl;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @JsonIgnore
    public boolean isBlocked() {
        return UserStatusE.BLOCKED.equals(statusE);
    }
}