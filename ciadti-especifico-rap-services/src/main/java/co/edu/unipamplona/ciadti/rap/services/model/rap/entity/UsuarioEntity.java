package co.edu.unipamplona.ciadti.rap.services.model.rap.entity;

import co.edu.unipamplona.ciadti.rap.services.config.jackson.JacksonRap;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@JacksonRap
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USUARIOS", schema = "LMS_NEV_2_0")
public class UsuarioEntity implements Serializable, Cloneable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;

    @Column(name = "ultima_sesion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaSesion;

    @Column(name = "actual_sesion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualSesion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "accion",   nullable = false)
    private String accion;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> roles = List.of("ROLE_ADMIN");
        List<GrantedAuthority> authorities = roles
            .stream()
            .map(rolSeguridad -> new SimpleGrantedAuthority(rolSeguridad))
            .collect(Collectors.toList());
        return authorities;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
