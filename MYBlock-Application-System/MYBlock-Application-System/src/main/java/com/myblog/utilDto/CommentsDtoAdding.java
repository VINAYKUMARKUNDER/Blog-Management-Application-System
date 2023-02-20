package com.myblog.utilDto;

import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
public class CommentsDtoAdding {
	
	@NotNull
	private String comment;

}
