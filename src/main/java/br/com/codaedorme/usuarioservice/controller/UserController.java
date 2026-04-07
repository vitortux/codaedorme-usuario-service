package br.com.codaedorme.usuarioservice.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codaedorme.usuarioservice.domain.dto.LoginDTO;
import br.com.codaedorme.usuarioservice.domain.dto.UserDTO;
import br.com.codaedorme.usuarioservice.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService service;

	@PostMapping("/login")
	public UserDTO login(@RequestBody @Valid final LoginDTO credentials) {
		return service.login(credentials);
	}

	@PostMapping("/create")
	public Long create(@RequestBody @Valid final UserDTO user) {
		return service.create(user);
	}
}
