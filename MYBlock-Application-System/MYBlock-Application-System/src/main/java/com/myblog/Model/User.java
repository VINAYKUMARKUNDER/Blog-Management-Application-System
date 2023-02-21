package com.myblog.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String userName;

	@Column(unique = true)
	private String email;

	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String userPassword;

	private String about;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Comments> comments = new ArrayList<>();
//
//	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
////	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id")
////	)
//	private Set<Role> roles = new HashSet<>();

	

}
