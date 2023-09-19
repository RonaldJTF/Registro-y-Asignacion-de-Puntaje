package co.edu.unipamplona.ciadti.rap.services.model.general.service.impl;

import co.edu.unipamplona.ciadti.rap.services.exception.RapException;
import co.edu.unipamplona.ciadti.rap.services.model.general.dao.PersonaGeneralDAO;
import co.edu.unipamplona.ciadti.rap.services.model.general.service.PersonaGeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class PersonaGeneralServiceImpl implements PersonaGeneralService {

    private final PersonaGeneralDAO personaGeneralDAO;

    @Override
    @Transactional(readOnly = true, value = "generalTransactionalManager")
    public Object findById(Long id) throws RapException {
        return personaGeneralDAO.findById(id).orElseThrow(() -> new RapException("PersonaGeneral no encontrado para el id :: " + id, 404));
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
