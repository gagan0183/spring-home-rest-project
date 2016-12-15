package com.personal.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personal.exception.PostVideotutorialException;
import com.personal.hateoas.assembler.VideotutorialResourceAssembler;
import com.personal.hateoas.resource.VideotutorialResource;
import com.personal.service.VideotutorialService;
import com.personal.util.SuccessMessage;

@RestController
public class VideotutorialController {
	private static final Logger LOGGER = LoggerFactory.getLogger(VideotutorialController.class.getPackage().getName());

	@Inject
	private VideotutorialService videotutorialService;

	@Inject
	private VideotutorialResourceAssembler videotutorialResourceAssembler;

	@Inject
	private MessageSource messageSource;

	@RequestMapping(value = "/videotutorial", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> addvideotutorial(
			@Valid @RequestBody VideotutorialResource videotutorialResource) {
		LOGGER.info("in addvideotutorial");

		VideotutorialResource returnvideotutorialResource = videotutorialService
				.addvideotutorial(videotutorialResource);
		if (returnvideotutorialResource == null) {
			throw new PostVideotutorialException(
					messageSource.getMessage("postvideotutorialexception.message", null, null));
		}
		SuccessMessage successMessage = new SuccessMessage(HttpStatus.OK.value(),
				messageSource.getMessage("successcpost.message", null, null));
		return new ResponseEntity<SuccessMessage>(successMessage, HttpStatus.OK);
	}
}
