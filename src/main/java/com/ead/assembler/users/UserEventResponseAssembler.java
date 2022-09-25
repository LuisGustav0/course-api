package com.ead.assembler.users;

import com.ead.model.UserModel;
import com.ead.model.response.users.UserEventResponse;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class UserEventResponseAssembler {

    public UserModel toModel(final UserEventResponse response) {
        return UserModel.builder()
                        .id(response.getId())
                        .email(response.getEmail())
                        .fullName(response.getFullName())
                        .statusE(response.getStatusE())
                        .typeE(response.getTypeE())
                        .cpf(response.getCpf())
                        .createdAt(OffsetDateTime.parse(response.getCreatedAt()))
                        .updatedAt(OffsetDateTime.parse(response.getUpdatedAt()))
                        .build();
    }
}
