package com.myblog.utilDto;

import java.util.List;



import lombok.Data;


@Data
public class PageResponse {
	
	private List<PostDto> content;
	private Integer pageNumber;
	private Integer pageSize;
	private Integer totalElement;
	private Integer totalPage;
	private boolean pageStatus;

}
