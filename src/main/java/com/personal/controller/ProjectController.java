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

import com.personal.exception.PostProjectException;
import com.personal.hateoas.assembler.ProjectResourceAssembler;
import com.personal.hateoas.resource.ProjectResource;
import com.personal.model.Project;
import com.personal.service.ProjectService;
import com.personal.util.SuccessMessage;

@RestController
public class ProjectController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class.getPackage().getName());

	@Inject
	private ProjectService projectService;

	@Inject
	private ProjectResourceAssembler projectResourceAssembler;

	@Inject
	private MessageSource messageSource;

	@RequestMapping(value = "/project", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> addProject(@Valid @RequestBody ProjectResource projectResource) {
		LOGGER.info("in addProject");

		Project returnProject = projectService.addProject(projectResource);
		if (returnProject == null) {
			throw new PostProjectException(messageSource.getMessage("postprojectexception.message", null, null));
		}
		SuccessMessage successMessage = new SuccessMessage(HttpStatus.OK.value(),
				messageSource.getMessage("successppost.message", null, null));
		return new ResponseEntity<SuccessMessage>(successMessage, HttpStatus.OK);
	}
}
