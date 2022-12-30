package com.userinfoapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;

	private String cpfValido;

	private String cpfInvalido;

	@BeforeEach
	void setUp() throws Exception {
		cpfValido = "656.548.496-11";
		cpfInvalido = "656.548.496-1123";
	}

	@Test
	public void validarDeveriaRetornarStatusOkQuandoCpfForValido() throws Exception {

		ResultActions result =
			mockMvc.perform(get("/users/{cpf}", cpfValido)
				.contentType(MediaType.APPLICATION_JSON));

		result.andExpectAll(status().isOk());
	}

	@Test
	public void validarDeveriaRetornarStatusNotFoundQuandoCpfForInvalido() throws Exception {

		ResultActions result =
			mockMvc.perform(get("/users/{cpf}", cpfInvalido)
				.contentType(MediaType.APPLICATION_JSON));

		result.andExpectAll(status().isNotFound());
	}

}
