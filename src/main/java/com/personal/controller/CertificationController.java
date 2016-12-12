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

import com.personal.exception.PostCertificationException;
import com.personal.hateoas.assembler.CertificationResourceAssembler;
import com.personal.hateoas.resource.CertificationResource;
import com.personal.service.CertificationService;
import com.personal.util.SuccessMessage;

@RestController
public class CertificationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CertificationController.class.getPackage().getName());

	@Inject
	private CertificationService certificationService;

	@Inject
	private CertificationResourceAssembler certificationResourceAssembler;

	@Inject
	private MessageSource messageSource;

	@RequestMapping(value = "/certification", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> addCertification(
			@Valid @RequestBody CertificationResource certificationResource) {
		LOGGER.info("in addCertification");

		CertificationResource returnCertificationResource = certificationService
				.addCertification(certificationResource);
		if (returnCertificationResource == null) {
			throw new PostCertificationException(
					messageSource.getMessage("postcertificationexception.message", null, null));
		}
		SuccessMessage successMessage = new SuccessMessage(HttpStatus.OK.value(),
				messageSource.getMessage("successcpost.message", null, null));
		return new ResponseEntity<SuccessMessage>(successMessage, HttpStatus.OK);
	}
}
