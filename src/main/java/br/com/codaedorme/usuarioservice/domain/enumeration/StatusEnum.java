package br.com.codaedorme.usuarioservice.domain.enumeration;

import lombok.Getter;

@Getter
public enum StatusEnum {

	ATIVO("Ativo"),
	INATIVO("Inativo");

	private final String description;

	StatusEnum(String description) {
		this.description = description;
	}
}
