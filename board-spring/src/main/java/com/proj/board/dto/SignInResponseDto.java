package com.proj.board.dto;

import com.proj.board.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseDto {
    public String token;
    public int expirTime;
    private UserEntity user;
}
