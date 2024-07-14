package com.api.VigiControl.Modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="personal", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Personal implements UserDetails {

    @Id
    @Column(length = 8)
    private String personalID;
    @Column(nullable = false)
    private String apeYnom;
    @Column(nullable = true)
    private Integer cargo;
    @Column(nullable = false)
    private int visible;
    @ManyToOne
    @JoinColumn(name = "gradoID")
    private Grado gradoID;
    @ManyToOne
    @JoinColumn(name = "comisariaID", nullable = true)
    private Comisaria comisariaID;
    @ManyToOne
    @JoinColumn(name = "domicilioID")
    private Domicilio domicilioID;
    @ManyToOne
    @JoinColumn(name = "distritoID")
    private Distrito distritoID;
    @ManyToOne
    @JoinColumn(name = "rolUsuarioID")
    private RolUsuario rolUsuarioID;
    @OneToMany(mappedBy = "servicioTareaID")
    @JsonIgnore
    private List<ServicioTarea> servicioTareaList;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rolUsuarioID.getDescripcion())));
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
}
