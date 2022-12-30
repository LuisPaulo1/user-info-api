package com.userinfoapi.controller.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private String status;
	private String error;
	private String mensagem;

}