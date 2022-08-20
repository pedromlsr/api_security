package api.security.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import api.security.learning.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

	public Optional<UsuarioModel> findByLogin(String login);
	
}
