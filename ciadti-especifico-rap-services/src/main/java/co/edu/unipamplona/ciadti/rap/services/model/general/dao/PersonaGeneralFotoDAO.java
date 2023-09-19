package co.edu.unipamplona.ciadti.rap.services.model.general.dao;

import co.edu.unipamplona.ciadti.rap.services.model.general.entity.PersonaGeneralFotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonaGeneralFotoDAO extends JpaRepository<PersonaGeneralFotoEntity, Long>, JpaSpecificationExecutor<PersonaGeneralFotoEntity> {
    PersonaGeneralFotoEntity findByIdPersonaGeneral (Long idPersonaGeneral);
}
