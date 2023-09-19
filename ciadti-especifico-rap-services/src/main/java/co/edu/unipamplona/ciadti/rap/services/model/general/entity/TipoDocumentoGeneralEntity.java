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
@Table(name = "TIPODOCUMENTOGENERAL", schema = "GENERAL")
public class TipoDocumentoGeneralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIDG_ID", nullable = false)
    private Long id;
    
    @Column(name = "TIDG_DESCRIPCION", nullable = false, length = 50)
    private String descripcion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "TIDG_REGISTRADOPOR", nullable = false, length = 30)
    private String registradoPor;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "TIDG_FECHACAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;
    
    @Column(name = "TIDG_TIPOPERSONA", nullable = false, length = 1)
    private String tipoPersona;
    
    @Column(name = "TIDG_ABREVIATURA", length = 5)
    private String abreviatura;
    
    @Column(name = "TIDG_FORMANUMERO", length = 12)
    private String formaNumero;
    
    @Column(name = "TIDG_USADIGVERIFICACION", length = 1)
    private String usaDigVerificacion;
}
