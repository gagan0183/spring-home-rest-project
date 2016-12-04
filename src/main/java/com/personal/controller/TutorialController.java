package com.personal.controller;

import java.util.List;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personal.exception.PostBookException;
import com.personal.hateoas.assembler.TutorialResourceAssembler;
import com.personal.hateoas.resource.TutorialResource;
import com.personal.model.Tutorial;
import com.personal.service.TutorialService;
import com.personal.util.SuccessMessage;

@RestController
public class TutorialController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TutorialController.class.getPackage().getName());

	@Autowired
	private TutorialService tutorialService;

	@Autowired
	private TutorialResourceAssembler tutorialResourceAssembler;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/tutorial", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> addTutorial(@RequestBody Tutorial tutorial) {
		LOGGER.info("in addTutorial");

		Tutorial returnTutorial = tutorialService.addTutorial(tutorial);
		if (returnTutorial == null) {
			throw new PostBookException(messageSource.getMessage("posttutorialexception.message", null, null));
		}
		SuccessMessage successMessage = new SuccessMessage(HttpStatus.OK.value(),
				messageSource.getMessage("successtutorialpost.message", null, null));
		return new ResponseEntity<SuccessMessage>(successMessage, HttpStatus.OK);
	}

	@RequestMapping(value = "/tutorial/{tutorialType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TutorialResource>> getTutorials(@PathVariable("tutorialType") String tutorialType)
			throws JSONException {
		LOGGER.info("in getTutorials");

		List<Tutorial> tutorials = tutorialService.getTutorialsByType(tutorialType);
		if (tutorials.size() == 0 || tutorials == null) {

		}
		List<TutorialResource> tutorialResources = tutorialResourceAssembler.toResources(tutorials);
		return new ResponseEntity<>(tutorialResources, HttpStatus.OK);
	}
}
