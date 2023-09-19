package co.edu.unipamplona.ciadti.rap.services.model.rap.dao;

import co.edu.unipamplona.ciadti.rap.services.model.rap.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDAO extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByUsername (String username);
}
