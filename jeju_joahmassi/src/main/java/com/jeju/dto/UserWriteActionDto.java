package com.jeju.dto;

import java.time.LocalDateTime;

import com.jeju.entity.Userinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserWriteActionDto {

	private Long userNo;
	private String signupId;
	private String signupPassword;
	private String signupName;
	private String signupResident;
	private String signupPhone;
	private String signupEmail;
	private LocalDateTime userRegisterDate;
	private Integer userPoint;
	
	public static Userinfo toEntity(UserWriteActionDto dto) {
		
		Userinfo userinfo = Userinfo.builder()
				.userId(dto.getSignupId())
				.userPassword(dto.getSignupPassword())
				.userName(dto.getSignupName())
				.userResident(dto.getSignupResident())
				.userPhone(dto.getSignupPhone())
				.userEmail(dto.getSignupEmail())
				.userRegisterDate(dto.getUserRegisterDate())
				.userPoint(dto.getUserPoint())
				.build();
		
		return userinfo;
	}
}
