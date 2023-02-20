package com.myblog.Exception;

public class ResponseNotFoundException extends RuntimeException{
	
	private String respnseName;
	private String responseMsg;
	private Integer userid;
	public ResponseNotFoundException(String respnseName, String responseMsg, Integer userid) {
		super(String.format("%s is not found with %s : %s", respnseName,responseMsg, userid));
		this.respnseName = respnseName;
		this.responseMsg = responseMsg;
		this.userid = userid;
	}
	
	

}
