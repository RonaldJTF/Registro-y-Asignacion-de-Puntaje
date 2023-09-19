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
@Table(name = "CIUDADGENERAL", schema = "GENERAL")
public class CiudadGeneralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CIGE_ID", nullable = false)
    private Long id;
    
    @Column(name = "DEGE_ID")
    private Long idDepartamento;
    
    @Column(name = "CIGE_NOMBRE", nullable = false, length = 50)
    private String nombre;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "CIGE_REGISTRADOPOR", nullable = false, length = 30)
    private String registradoPor;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "CIGE_FECHACAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;

    @OneToOne
    @JoinColumn(name = "DEGE_ID", insertable=false, updatable=false)
    private DepartamentoGeneralEntity departamento;

}
