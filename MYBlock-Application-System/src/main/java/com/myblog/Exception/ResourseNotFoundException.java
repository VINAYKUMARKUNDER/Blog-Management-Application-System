package com.myblog.Exception;

public class ResourseNotFoundException extends RuntimeException{
	
	private String respnseName;
	private String responseMsg;
	private String name;
	public ResourseNotFoundException(String respnseName, String responseMsg, String name) {
		super(String.format("%s is not found with %s : %s", respnseName,responseMsg, name));
		this.respnseName = respnseName;
		this.responseMsg = responseMsg;
		this.name = name;
	}
}
