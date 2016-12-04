package com.personal.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.model.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

	public List<Tutorial> findByTutorialType(String tutorialType);
}
