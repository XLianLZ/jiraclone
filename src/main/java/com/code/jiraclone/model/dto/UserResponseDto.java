package com.code.jiraclone.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String profilePhotoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
