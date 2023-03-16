package com.tcs.com.tcs.XMlexample.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialService {
	@Autowired
	TutorialRepository repository;
	public List<Tutorial> getAll(){
		return repository.findAll();
	}
	public Tutorial getTutorial(long id) {
		return repository.findTutorialById(id);
	}
	public void deleteTutorial(long id) {
		repository.deleteById(id);
	}
	public Tutorial createTutorial(Tutorial tutorial) {
		return repository.save(tutorial);
	}
}
