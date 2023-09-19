package co.edu.unipamplona.ciadti.rap.services.config.security.register;

import co.edu.unipamplona.ciadti.rap.services.model.common.dto.AccionDTO;

public class RegisterContext {

    private static final ThreadLocal<AccionDTO> REGISTER = new ThreadLocal<>();

    public static AccionDTO getAccionDTO() {
        return REGISTER.get();
    }

    public static void setAccionDTO(AccionDTO accionDTO) {
        REGISTER.set(accionDTO);
    }
}