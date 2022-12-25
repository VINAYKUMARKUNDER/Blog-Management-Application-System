package com.myblog.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myblog.utilDto.ResponceModel;

@ControllerAdvice
public class GlobalExceptionHandeler {

	@ExceptionHandler(ResponseNotFoundException.class)
	public ResponseEntity<ResponceModel> ResponseNotFoundExceptionHandeler(ResponseNotFoundException rs) {

		ResponceModel msg = new ResponceModel(rs.getMessage(), false, LocalDateTime.now());
		return new ResponseEntity<ResponceModel>(msg, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ResponceModel> DataIntegrityViolationExceptionHandler(Exception rs) {
//		ResponceModel msg = new ResponceModel("Some Error in backend please infrom Admin fixed soon..", false, LocalDateTime.now());
//		return new ResponseEntity<ResponceModel>(msg, HttpStatus.BAD_REQUEST);
//	}

}
