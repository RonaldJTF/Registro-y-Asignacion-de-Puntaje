package co.edu.unipamplona.ciadti.rap.services.model.common.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class AccionDTO {
    @NotBlank(message = "No puede ser vacío")
    private String registradoPor;
    private String ip;
    private Date fechaCambio;

    public static AccionDTO getAccionDTOFromAccion(String textJson){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.fromJson(textJson, AccionDTO.class);
    }

    public String getJsonAsString(){
        this.fechaCambio = new Date();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return (gson.toJson(this));
    }
}
