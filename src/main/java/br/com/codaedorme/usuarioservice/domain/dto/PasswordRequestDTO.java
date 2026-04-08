package br.com.codaedorme.usuarioservice.domain.dto;

public record PasswordRequestDTO(String pwd, String confirmPwd) {

	public boolean pwdEquals() {
		return this.pwd != null && this.pwd.equals(this.confirmPwd);
	}
}
