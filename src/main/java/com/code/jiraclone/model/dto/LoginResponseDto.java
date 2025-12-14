package com.code.jiraclone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String token; // JWT token (we'll add this with Spring Security)
    private UserResponseDto user;
}
