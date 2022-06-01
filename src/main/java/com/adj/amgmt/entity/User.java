package com.adj.amgmt.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	public User(int i, String string, Set<UserRole> r) {
		
	}

	public User(String string, String string2, boolean b, Set<UserRole> r) {
		this.username=string;
		this.password=string2;
		this.enabled=b;
		this.userRole=r;
	}

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

//	@Column(name = "user_role", nullable = false)
	@OneToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	@JoinTable(name = "user_and_role",joinColumns = @JoinColumn(name="username") ,inverseJoinColumns = @JoinColumn(name="userRoleId"))
	private Set<UserRole> userRole;

}
