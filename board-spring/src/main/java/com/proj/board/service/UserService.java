package com.proj.board.service;

import com.proj.board.dto.PatchUserDto;
import com.proj.board.dto.PatchUserResponseDto;
import com.proj.board.dto.ResponseDto;
import com.proj.board.entity.UserEntity;
import com.proj.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseDto<PatchUserResponseDto> patchUser(PatchUserDto dto, String userEmail){
        UserEntity userEntity;
        String userNickname = dto.getUserNickname();
        String userProfile = dto.getUserProfile();

        try {
            userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null) return ResponseDto.setFailed("존재하지않는 이용자입니다.");

            userEntity.setUserNickname(userNickname);
            userEntity.setUserProfile(userProfile);

            userRepository.save(userEntity);
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 오류");
        }

        userEntity.setUserPassword("");

        PatchUserResponseDto patchUserResponseDto = new PatchUserResponseDto(userEntity);

        return ResponseDto.setSuccess("Success", patchUserResponseDto);
    }
}
