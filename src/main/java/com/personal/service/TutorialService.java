package com.personal.service;

import java.util.List;

import com.personal.model.Tutorial;

public interface TutorialService {
	public List<Tutorial> getTutorialsByType(String type);

	public Tutorial addTutorial(Tutorial tutorial);
}
