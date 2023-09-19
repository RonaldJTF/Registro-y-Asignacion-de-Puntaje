package co.edu.unipamplona.ciadti.rap.services.model.general.service.impl;

import co.edu.unipamplona.ciadti.rap.services.exception.RapException;
import co.edu.unipamplona.ciadti.rap.services.model.general.dao.PersonaGeneralFotoDAO;
import co.edu.unipamplona.ciadti.rap.services.model.general.service.PersonaGeneralFotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class PersonaGeneralFotoServiceImpl implements PersonaGeneralFotoService {

    private final PersonaGeneralFotoDAO personaGeneralFotoDAO;

    @Override
    @Transactional(readOnly = true, value = "generalTransactionalManager")
    public Object findById(Long id) throws RapException {
        return personaGeneralFotoDAO.findById(id).orElseThrow(() -> new RapException("PersonaGeneralFoto no encontrado para el id :: " + id, 404));
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
}
