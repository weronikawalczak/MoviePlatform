package com.example.demo.entity;

import com.example.demo.util.Role;
import com.example.demo.util.State;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Builder
@Entity
@Data
public class SystemUser implements UserDetails {
    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

//    @Enumerated(EnumType.STRING)
    private String role;

    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany
    private List<Movie> favourites;

    @OneToMany
    private List<Movie> toWatch;

    public SystemUser() {}

    public SystemUser(String email,  String password){
        this.email = email;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority("ROLE_" + role));
        return list;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return state != State.BANNED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return state != State.INACTIVE;
    }
}
