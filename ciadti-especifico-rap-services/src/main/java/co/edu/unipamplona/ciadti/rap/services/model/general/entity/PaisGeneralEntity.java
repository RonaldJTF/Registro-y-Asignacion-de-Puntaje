package co.edu.unipamplona.ciadti.rap.services.model.general.entity;

import co.edu.unipamplona.ciadti.rap.services.config.jackson.JacksonRap;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@JacksonRap
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PAISGENERAL", schema = "GENERAL")
public class PaisGeneralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAGE_ID", nullable = false, length = 2)
    private String id;
    
    @Column(name = "PAGE_NOMBRE", nullable = false, length = 50)
    private String nombre;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PAGE_REGISTRADOPOR", nullable = false, length = 30)
    private String registradoPor;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PAGE_FECHACAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;
    
    @Column(name = "PAGE_CODIGODANE", length = 5)
    private String codigoDane;
    
    @Column(name = "PAGE_CODIGOISONUMERICO", length = 5)
    private String codigoIsoNumerico;
}
