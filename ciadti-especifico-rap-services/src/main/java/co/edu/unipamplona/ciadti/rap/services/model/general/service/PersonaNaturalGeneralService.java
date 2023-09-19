package co.edu.unipamplona.ciadti.rap.services.model.general.service;

import co.edu.unipamplona.ciadti.rap.services.model.common.service.CommonService;
import co.edu.unipamplona.ciadti.rap.services.model.general.entity.PersonaNaturalGeneralEntity;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface PersonaNaturalGeneralService extends CommonService {
    DataTablesOutput<PersonaNaturalGeneralEntity> findAll (DataTablesInput dataTablesInput);
    List<PersonaNaturalGeneralEntity> findAllFilteredBy(PersonaNaturalGeneralEntity filter);
}
