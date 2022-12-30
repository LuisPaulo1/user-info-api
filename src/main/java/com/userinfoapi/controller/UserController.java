package com.userinfoapi.controller;

import com.userinfoapi.controller.dto.UserResultDto;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("users")
public class UserController {

	@GetMapping("{cpf}")
	public ResponseEntity<UserResultDto> validar(@CPF @PathVariable String cpf){
		return ResponseEntity.ok(new UserResultDto());
	}

}
