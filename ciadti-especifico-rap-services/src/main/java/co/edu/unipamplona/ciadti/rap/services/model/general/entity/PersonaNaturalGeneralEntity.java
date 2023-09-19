package co.edu.unipamplona.ciadti.rap.services.model.general.entity;

import co.edu.unipamplona.ciadti.rap.services.config.jackson.JacksonRap;
import co.edu.unipamplona.ciadti.rap.services.util.Image;
import com.fasterxml.jackson.annotation.*;
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
@Table(name = "PERSONANATURALGENERAL", schema = "GENERAL")
public class PersonaNaturalGeneralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PEGE_ID", nullable = false)
    private Long id;
    
    @Column(name = "PENG_PRIMERAPELLIDO", nullable = false, length = 50)
    private String primerApellido;
    
    @Column(name = "PENG_SEGUNDOAPELLIDO", length = 50)
    private String segundoApellido;
    
    @Column(name = "PENG_SEXO", nullable = false, length = 5)
    private String sexo;
    
    @Column(name = "PENG_FECHANACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    
    @Column(name = "CIGE_IDLUGARNACIMIENTO")
    private Long idLugarNacimiento;
    
    @Column(name = "ESCG_ID")
    private Long idEstadoCivil;
    
    @Column(name = "PENG_LIBRETAMILITAR", length = 15)
    private String libretaMilitar;
    
    @Column(name = "PENG_RH", length = 4)
    private String rh;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PENG_REGISTRADOPOR", nullable = false, length = 30)
    private String registradoPor;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PENG_FECHACAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;
    
    @Column(name = "PENG_PRIMERNOMBRE", nullable = false, length = 50)
    private String primerNombre;
    
    @Column(name = "PENG_SEGUNDONOMBRE", length = 50)
    private String segundoNombre;
    
    @Column(name = "PENG_DISTRITOMILITAR", length = 10)
    private String distritoMilitar;
    
    @Column(name = "PENG_NUMEROPASAPORTE", length = 20)
    private String numeroPasaporte;
    
    @Column(name = "REGE_ID")
    private Long idReligion;
    
    @Column(name = "PAGE_IDNACIONALIDAD", length = 2)
    private String idNacionalidad;
    
    @Column(name = "PENG_OTRANACIONALIDAD", length = 30)
    private String otraNacionalidad;
    
    @Column(name = "PENG_EMAILINSTITUCIONAL", length = 100)
    private String emailInstitucional;
    
    @Column(name = "PAGE_IDNACIMIENTO", length = 2)
    private String idPaisNacimiento;
    
    @Column(name = "PENG_UBICACIONFISICAHOJAVIDA", length = 200)
    private String ubicacionFisicaHojaVida;
    
    @Column(name = "PENG_CLASELIBRETAMILITAR", length = 20)
    private String  claseLibretaMilitar;
    
    @Column(name = "PENG_VIVE", nullable = false, length = 1)
    private String vive;
    
    @Column(name = "PENG_FAX", length = 20)
    private String fax;
    
    @Column(name = "PENG_FECHAVIGENCIAPASAPORTE")
    private Date fechaVigenciaPasaporte;

    @OneToOne
    @JoinColumn(name = "PEGE_ID", insertable=false, updatable=false)
    private PersonaGeneralEntity personaGeneral;

    @OneToOne
    @JoinColumn(name = "PAGE_IDNACIONALIDAD", insertable=false, updatable=false)
    private PaisGeneralEntity nacionalidad;

    @OneToOne
    @JoinColumn(name = "CIGE_IDLUGARNACIMIENTO", insertable=false, updatable=false)
    private CiudadGeneralEntity lugarNacimiento;

    @OneToOne
    @JoinColumn(name = "PAGE_IDNACIMIENTO", insertable=false, updatable=false)
    private PaisGeneralEntity paisNacimiento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESCG_ID", insertable=false, updatable=false)
    private EstadoCivilGeneralEntity estadoCivil;

    @JsonIgnore
    @JsonManagedReference
    @OneToOne (mappedBy = "personaNaturalGeneral")
    private PersonaGeneralFotoEntity fotoPersona;

    @Transient
    private String srcFoto;

    @JsonGetter("srcFoto")
    public String getSrcFoto() {
        return fotoPersona != null
                ? Image.getSrcImage(fotoPersona.getArchivo(), "image/" + fotoPersona.getExtension())
                : null;
    }
}
