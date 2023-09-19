package co.edu.unipamplona.ciadti.rap.services.model.general.service.impl;

import co.edu.unipamplona.ciadti.rap.services.config.specification.OrderBy;
import co.edu.unipamplona.ciadti.rap.services.config.specification.SpecificationRap;
import co.edu.unipamplona.ciadti.rap.services.exception.RapException;
import co.edu.unipamplona.ciadti.rap.services.model.general.dao.PersonaGeneralFotoDAO;
import co.edu.unipamplona.ciadti.rap.services.model.general.dao.PersonaNaturalGeneralDAO;
import co.edu.unipamplona.ciadti.rap.services.model.general.entity.PersonaNaturalGeneralEntity;
import co.edu.unipamplona.ciadti.rap.services.model.general.service.PersonaNaturalGeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonaNaturalGeneralServiceImpl implements PersonaNaturalGeneralService {

    private final PersonaNaturalGeneralDAO personaNaturalGeneralDAO;

    @Override
    @Transactional(readOnly = true, value = "generalTransactionalManager")
    public Object findById(Long id) throws RapException {
        return personaNaturalGeneralDAO.findById(id).orElseThrow(() -> new RapException("PersonaNaturalGeneral no encontrado para el id :: " + id, 404));
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
    @Transactional(readOnly = true, value = "generalTransactionalManager")
    public DataTablesOutput<PersonaNaturalGeneralEntity> findAll(DataTablesInput dataTablesInput) {
        return personaNaturalGeneralDAO.findAll(dataTablesInput);
    }

    @Override
    @Transactional(readOnly = true, value = "generalTransactionalManager")
    public List<PersonaNaturalGeneralEntity> findAllFilteredBy(PersonaNaturalGeneralEntity filter) {
        OrderBy orderBy = new OrderBy();
        orderBy.addOrder("primerNombre", true);
        orderBy.addOrder("segundoNombre", true);
        Specification<PersonaNaturalGeneralEntity> specification = new SpecificationRap<>(filter, orderBy);
        return personaNaturalGeneralDAO.findAll(specification);
    }
}
