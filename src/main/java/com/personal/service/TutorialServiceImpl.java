package com.personal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.model.Tutorial;
import com.personal.rep.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;

	@Override
	public List<Tutorial> getTutorialsByType(String type) {
		return tutorialRepository.findByTutorialType(type);
	}

	@Override
	public Tutorial addTutorial(Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}
}
