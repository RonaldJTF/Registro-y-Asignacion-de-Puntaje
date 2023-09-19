package co.edu.unipamplona.ciadti.rap.services.model.rap.service;

import co.edu.unipamplona.ciadti.rap.services.model.common.service.CommonService;
import co.edu.unipamplona.ciadti.rap.services.model.rap.entity.UsuarioEntity;

public interface UsuarioService extends CommonService {
    UsuarioEntity findByUsername (String userName);
}
