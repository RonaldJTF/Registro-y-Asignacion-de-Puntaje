package co.edu.unipamplona.ciadti.rap.services.model.general.entity;

import co.edu.unipamplona.ciadti.rap.services.config.jackson.JacksonRap;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "PERSONAGENERALFOTO", schema = "GENERAL", catalog = "")
public class PersonaGeneralFotoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PEGE_ID", nullable = false)
    private Long idPersonaGeneral;
    
    @Column(name = "PGFO_IDENTIFICADOR", nullable = false)
    private Long id;
    
    @Column(name = "PGFO_ARCHIVO", nullable = false)
    private byte[] archivo;
    
    @Column(name = "PGFO_EXTENSION", nullable = false, length = 10)
    private String extension;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PGFO_FECHACAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PGFO_REGISTRADOPOR", nullable = false, length = 30)
    private String registradoPor;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "PEGE_ID", insertable=false, updatable=false)
    private PersonaNaturalGeneralEntity personaNaturalGeneral;

}
