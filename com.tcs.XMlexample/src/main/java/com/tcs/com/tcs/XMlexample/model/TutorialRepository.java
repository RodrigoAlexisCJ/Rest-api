package com.tcs.com.tcs.XMlexample.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends CrudRepository<Tutorial,Long>{
	List<Tutorial> findByPublished(boolean published);
	List<Tutorial> findByTitleContaining(String title);
	Tutorial findTutorialById(Long id);
	@Override
	List<Tutorial> findAll();
//	@Query("Delete t from tutorials t where t.id = ?1")
//	Tutorial deleteTutorial(Long id);
	
}
