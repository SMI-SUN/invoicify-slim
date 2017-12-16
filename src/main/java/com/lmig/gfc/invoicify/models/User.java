package com.lmig.gfc.invoicify.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="invoicify_user")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@JsonIgnore
	@Column(nullable = false)
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Role> roles;

	public User() {
		roles = new ArrayList<Role>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public boolean canSeeAdmin() {
		return hasRole("ADMIN");
	}

	public boolean canSeeInvoices() {
		return hasRole("ACCOUNTANT") || hasRole("ADMIN");
	}

	public boolean canSeeBillingRecords() {
		return hasRole("CLERK") || hasRole("ADMIN");
	}
	
	public void addRole(String roleName) {
		Role role = new Role();
		role.setName(roleName);
		role.setUser(this);
		roles.add(role);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (Role role : roles) {
			String roleName = "ROLE_" + role.getName();
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleName);
			authorities.add(authority);
		}
		
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
	
	private boolean hasRole(String roleName) {
		boolean hasRole = false;
		for (Role role : roles) {
			if (role.getName().equals(roleName)) {
				hasRole = true;
				break;
			}
		}
		return hasRole;
	}

}
