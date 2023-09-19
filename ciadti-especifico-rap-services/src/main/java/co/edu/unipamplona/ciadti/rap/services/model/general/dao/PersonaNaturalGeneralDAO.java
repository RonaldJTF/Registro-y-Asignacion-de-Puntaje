package co.edu.unipamplona.ciadti.rap.services.model.general.dao;

import co.edu.unipamplona.ciadti.rap.services.model.general.entity.PersonaNaturalGeneralEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface PersonaNaturalGeneralDAO extends  DataTablesRepository<PersonaNaturalGeneralEntity, Long> {
}
