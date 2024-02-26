package com.jeju.dto;

import java.util.List;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class UserUpdateDto {

	private String userPassword;
	private String userEmail;
	private String userPhone;
}
