package br.com.codaedorme.usuarioservice.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codaedorme.usuarioservice.domain.dto.PasswordRequestDTO;
import br.com.codaedorme.usuarioservice.domain.dto.UserDTO;
import br.com.codaedorme.usuarioservice.exception.BusinessException;
import br.com.codaedorme.usuarioservice.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService service;

	@PutMapping("/{id}/update-password")
	public void updatePwd(@PathVariable Long id, @RequestBody PasswordRequestDTO request) throws BusinessException {
		service.updatePwd(id, request);
	}

	@GetMapping
	public List<UserDTO> findAll() {
		return service.findAll();
	}
}
