package br.com.gotea.domain.model;

import br.com.gotea.domain.enums.RoleModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    @ToString.Exclude
    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleModel roleModel;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.roleModel == RoleModel.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.email;
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
