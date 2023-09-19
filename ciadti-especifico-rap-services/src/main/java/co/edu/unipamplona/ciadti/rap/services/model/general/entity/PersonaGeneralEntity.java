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
@Table(name = "PERSONAGENERAL", schema = "GENERAL")
public class PersonaGeneralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PEGE_ID", nullable = false)
    private Long id;
    
    @Column(name = "PEGE_TIPOPERSONA", nullable = false)
    private Byte tipoPersona;
    
    @Column(name = "CIGE_IDRESIDENCIA")
    private Long idCiudadResidencia;
    
    @Column(name = "PEGE_DIRECCION", length = 100)
    private String direccion;
    
    @Column(name = "PEGE_MAIL", length = 100)
    private String mail;
    
    @Column(name = "PEGE_TELEFONOCELULAR", length = 30)
    private String telefonoCelular;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PEGE_REGISTRADOPOR", nullable = false, length = 30)
    private String registradoPor;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PEGE_FECHACAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;
    
    @Column(name = "PEGE_TELEFONO", length = 50)
    private String telefono;
    
    @Column(name = "PEGE_DIRECCION2", length = 100)
    private String direccion2;
    
    @Column(name = "PEGE_TELEFONO2", length = 50)
    private String telefono2;
    
    @Column(name = "CIGE_IDRESIDENCIA2")
    private Long idCiudadResidencia2;
    
    @Column(name = "PAGE_IDRESIDENCIA1", length = 2)
    private String idPaisResidencia1;
    
    @Column(name = "PAGE_IDRESIDENCIA2", length = 2)
    private String idPaisResidencia2;
    
    @Column(name = "TIDG_ID", nullable = false)
    private Long idTipoDocumento;
    
    @Column(name = "PEGE_DOCUMENTOIDENTIDAD", nullable = false, length = 50)
    private String documentoIdentidad;
    
    @Column(name = "PEGE_LUGAREXPEDICION", length = 50)
    private String lugarExpedicion;
    
    @Column(name = "PEGE_FECHAEXPEDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpedicion;
    
    @Column(name = "INST_CODIGOSNP", length = 50)
    private String codigoSNP;
    
    @Column(name = "PEGE_DIGITOVERIFICACION", length = 2)
    private String digitoVerificacion;
    
    @Column(name = "ACEC_IDDIAN")
    private Integer idDian;
    
    @Column(name = "ACEC_IDICA")
    private Integer idIca;
    
    @Column(name = "PEGE_NOMBRECOMERCIAL", length = 200)
    private String nombreComercial;
    
    @Column(name = "PEGE_NUMERORESOLUCION", length = 20)
    private String numeroResolucion;
    
    @Column(name = "REGI_ID")
    private Long idRegimen;

    @OneToOne
    @JoinColumn(name = "CIGE_IDRESIDENCIA", insertable=false, updatable=false)
    private CiudadGeneralEntity ciudadResidencia;

    @OneToOne
    @JoinColumn(name = "CIGE_IDRESIDENCIA2", insertable=false, updatable=false)
    private CiudadGeneralEntity ciudadResidencia2;

    @OneToOne
    @JoinColumn(name = "PAGE_IDRESIDENCIA1", insertable=false, updatable=false)
    private PaisGeneralEntity paisResidencia;

    @OneToOne
    @JoinColumn(name = "PAGE_IDRESIDENCIA2", insertable=false, updatable=false)
    private PaisGeneralEntity paisResidencia2;

    @OneToOne
    @JoinColumn(name = "TIDG_ID", insertable=false, updatable=false)
    private TipoDocumentoGeneralEntity tipoDocumento;
}
