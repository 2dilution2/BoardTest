package com.proj.board.entity;

import com.proj.board.dto.SignUpDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "User")
public class UserEntity {

    @Id
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userPhoneNum;
    private String userAddress;
    private String userProfile;

    public UserEntity(SignUpDto dto){
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
        this.userNickname = dto.getUserNickname();
        this.userPhoneNum = dto.getUserPhoneNum();
        this.userAddress = dto.getUserAddress() + " " + dto.getUserAddressDetail();
    }
}
