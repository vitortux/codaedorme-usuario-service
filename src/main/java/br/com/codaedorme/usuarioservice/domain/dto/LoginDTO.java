package br.com.codaedorme.usuarioservice.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
		@NotBlank(message = "Campo obrigatório") @Email String email,
		@NotBlank(message = "Campo obrigatório") String password) {}
