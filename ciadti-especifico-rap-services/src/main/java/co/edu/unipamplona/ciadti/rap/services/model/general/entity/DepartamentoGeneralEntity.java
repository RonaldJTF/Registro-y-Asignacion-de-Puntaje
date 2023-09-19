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
@Table(name = "DEPARTAMENTOGENERAL", schema = "GENERAL")
public class DepartamentoGeneralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEGE_ID", nullable = false)
    private Long id;
    
    @Column(name = "DEGE_NOMBRE", nullable = false, length = 80)
    private String nombre;
    
    @Column(name = "PAGE_ID", nullable = false, length = 2)
    private String idPais;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "DEGE_REGISTRADOPOR", nullable = false, length = 30)
    private String registradoPor;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "DEGE_FECHACAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;
}
