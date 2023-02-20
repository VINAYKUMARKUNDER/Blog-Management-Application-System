package com.myblog.utilDto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponceModel {
	
	private String Massege;
	private boolean status;
	private LocalDateTime DateAndTime;
	

}
