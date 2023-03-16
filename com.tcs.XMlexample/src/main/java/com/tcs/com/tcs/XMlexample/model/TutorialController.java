package com.tcs.com.tcs.XMlexample.model;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TutorialController {

	@Autowired
	TutorialService service;
	
	@GetMapping(value="/tutorials")
	ResponseEntity<List<Tutorial>> getTutorials(){
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	@GetMapping(value="/tutorials/{id}")
	ResponseEntity<Tutorial> getTutorial(@PathVariable long id){
		Tutorial tutorialFound = service.getTutorial(id);
		if(tutorialFound==null) {
			throw new TutorialNotFoundException("Tutorial not Found id =" + id);
		}
		else {
			return new ResponseEntity<>(tutorialFound,HttpStatus.OK);
		}
	}
	
//	@DeleteMapping(value="/tutorials/{id}")
//	public ResponseEntity<Void> deleteTodo(
//			@PathVariable long id){
//		Tutorial tutorial=service.deleteTutorial(id);
//		return tutorial!=null?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
////		if(todo != null) {
////			return ResponseEntity.noContent().build();
////		}
////		return ResponseEntity.notFound().build();
//		
//	}
	
	@PostMapping(value="/tutorials")
	public ResponseEntity<Void> addTutorial( 
			@Valid @RequestBody Tutorial tutorial){
		Tutorial createdTutorial = service.createTutorial(tutorial);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(createdTutorial.getId()).toUri();
	return ResponseEntity.created(uri).build();	
	}
	
}
