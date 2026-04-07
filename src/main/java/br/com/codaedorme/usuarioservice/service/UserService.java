package br.com.codaedorme.usuarioservice.service;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.codaedorme.usuarioservice.domain.dto.LoginDTO;
import br.com.codaedorme.usuarioservice.domain.dto.UserDTO;
import br.com.codaedorme.usuarioservice.domain.entity.User;
import br.com.codaedorme.usuarioservice.domain.enumeration.StatusEnum;
import br.com.codaedorme.usuarioservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;

	private static final ModelMapper mapper = new ModelMapper();

	private static final BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder(12);

	public Long create(final UserDTO user) {
		User entity = mapper.map(user, User.class);
		StatusEnum status = StatusEnum.ATIVO;
		String cryptogrifiedPwd = pwdEncoder.encode(user.getPassword());

		entity.setStatus(status);
		entity.setPassword(cryptogrifiedPwd);

		return repository.save(entity).getId();
	}

	public UserDTO login(final LoginDTO credentials) {
		User entity = repository.findByEmail(credentials.email()).orElseThrow(() -> new RuntimeException());

		if (!pwdEncoder.matches(credentials.password(), entity.getPassword())) {
			throw new RuntimeException();
		}

		return mapper.map(entity, UserDTO.class);
	}
}
