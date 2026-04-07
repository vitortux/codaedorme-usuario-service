package br.com.codaedorme.usuarioservice.domain.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.codaedorme.usuarioservice.domain.enumeration.StatusEnum;
import br.com.codaedorme.usuarioservice.domain.enumeration.UserGroupEnum;

@Getter
@Setter
public class UserDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@NotBlank(message = "Nome obrigatório")
	private String name;

	@Email(message = "E-mail inválido")
	@NotBlank(message = "E-mail obrigatório")
	private String email;

	@CPF(message = "CPF inválido.")
	@NotBlank(message = "CPF obrigatório")
	private String cpf;

	@Enumerated(EnumType.STRING)
	private UserGroupEnum userGroup;

	@JsonProperty(access = Access.READ_ONLY)
	private StatusEnum status;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
}
