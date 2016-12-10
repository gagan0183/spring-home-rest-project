package com.personal.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personal.exception.PostVideoException;
import com.personal.hateoas.assembler.VideoResourceAssembler;
import com.personal.model.Video;
import com.personal.service.VideoService;
import com.personal.util.SuccessMessage;

@RestController
public class VideoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class.getPackage().getName());

	@Autowired
	private VideoService videoService;

	@Autowired
	private VideoResourceAssembler videoResourceAssembler;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/video", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessMessage> addVideo(@Valid @RequestBody Video video) {
		LOGGER.info("in addVideo");

		Video returnVideo = videoService.addVideo(video);
		if (returnVideo == null) {
			throw new PostVideoException(messageSource.getMessage("postvideoexception.message", null, null));
		}
		SuccessMessage successMessage = new SuccessMessage(HttpStatus.OK.value(),
				messageSource.getMessage("successvpost.message", null, null));
		return new ResponseEntity<SuccessMessage>(successMessage, HttpStatus.OK);
	}

}
