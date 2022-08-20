package api.security.learning.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import api.security.learning.data.DetalheUsuarioData;
import api.security.learning.model.UsuarioModel;
import api.security.learning.repository.UsuarioRepository;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository repository;
	
//	private final UsuarioRepository repository;
//	
//	public DetalheUsuarioServiceImpl(UsuarioRepository repository) {
//		this.repository = repository;
//	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UsuarioModel> usuario = repository.findByLogin(username);
		
		if (usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
		}
		
		return new DetalheUsuarioData(usuario);
	}

}
