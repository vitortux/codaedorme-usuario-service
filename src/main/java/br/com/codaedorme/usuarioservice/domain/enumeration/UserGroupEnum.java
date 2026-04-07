package br.com.codaedorme.usuarioservice.domain.enumeration;

import lombok.Getter;

@Getter
public enum UserGroupEnum {

	ADMINISTRADOR("Administrador"),
	ESTOQUISTA("Estoquista");

	private final String description;

	UserGroupEnum(String description) {
		this.description = description;
	}
}
