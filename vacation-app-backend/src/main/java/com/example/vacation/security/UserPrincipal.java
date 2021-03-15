package com.example.vacation.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.vacation.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrincipal implements UserDetails {
	private Long id;
	private String username;
    private String name;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String username, String name, String password, Collection<? extends GrantedAuthority> authorities) {
    	this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
    	ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    	authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    	
        return new UserPrincipal(
        		user.getId(),
                user.getUsername(),
                user.getName(),
                user.getPassword(),
                authorities
        );
    }
    
    public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

    @Override
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username);
    }
}
