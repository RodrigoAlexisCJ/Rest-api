package com.tcs.com.tcs.XMlexample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

	@GetMapping(value="/hello")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<>("Hello",HttpStatus.OK);
	}
}
