package br.com.codaedorme.usuarioservice.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.codaedorme.usuarioservice.domain.dto.PasswordRequestDTO;
import br.com.codaedorme.usuarioservice.domain.dto.UserDTO;
import br.com.codaedorme.usuarioservice.domain.entity.User;
import br.com.codaedorme.usuarioservice.exception.BusinessException;
import br.com.codaedorme.usuarioservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;

	private static final ModelMapper mapper = new ModelMapper();

	private static final BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder(12);

	public void updatePwd(final Long id, final PasswordRequestDTO request) throws BusinessException {
		User entity = repository.findById(id)
				.orElseThrow(() -> new BusinessException("Não foi possível encontrar este usuário", HttpStatus.BAD_REQUEST));

		if (!request.pwdEquals()) {
			throw new BusinessException("Senhas não batem", HttpStatus.BAD_REQUEST);
		}

		String newPwd = pwdEncoder.encode(request.pwd());

		entity.setPassword(newPwd);
	}

	public List<UserDTO> findAll() {
		List<User> entities = repository.findAll();

		List<UserDTO> response = entities.stream()
				.map(entity -> mapper.map(entity, UserDTO.class))
				.toList();

		return response;
	}
}
