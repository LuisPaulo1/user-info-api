package com.userinfoapi.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResultDto {
	private String status;

	public UserResultDto(){
		this.status = "ABLE_TO_VOTE";
	}

}
