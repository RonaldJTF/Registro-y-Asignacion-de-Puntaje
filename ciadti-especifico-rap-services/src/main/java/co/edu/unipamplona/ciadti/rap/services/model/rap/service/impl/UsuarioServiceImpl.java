package co.edu.unipamplona.ciadti.rap.services.model.rap.service.impl;

import co.edu.unipamplona.ciadti.rap.services.exception.RapException;
import co.edu.unipamplona.ciadti.rap.services.model.rap.dao.UsuarioDAO;
import co.edu.unipamplona.ciadti.rap.services.model.rap.entity.UsuarioEntity;
import co.edu.unipamplona.ciadti.rap.services.model.rap.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDAO usuarioDAO;

    @Override
    @Transactional(readOnly = true, value = "rapTransactionalManager")
    public Object findById(Long id) throws RapException {
        return usuarioDAO.findById(id).orElseThrow(() -> new RapException("Usuario no encontrado para el id :: " + id, 404));
    }

    @Override
    public Iterable findAll() {
        return null;
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public Iterable save(Collection entities) {
        return null;
    }

    @Override
    @Transactional(readOnly = true, value = "rapTransactionalManager")
    public UsuarioEntity findByUsername(String username) {
        return usuarioDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Nombre de Usuario " + username + " no encontrado."));
    }
}
