package com.myblog.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	private String postTitle;
	
	@Column(length = 1000000000)
	private String content;
	private String postImage;
	private LocalDate date;
	
	@ManyToOne
	private User users;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL)
	private List<Comments> comments = new ArrayList<>();
	
}
