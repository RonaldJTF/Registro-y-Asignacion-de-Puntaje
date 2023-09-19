package co.edu.unipamplona.ciadti.rap.services.model.general.dao;

import co.edu.unipamplona.ciadti.rap.services.model.general.entity.PersonaGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonaGeneralDAO extends JpaRepository<PersonaGeneralEntity, Long>, JpaSpecificationExecutor<PersonaGeneralEntity> {
}
