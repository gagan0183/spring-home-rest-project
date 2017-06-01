package com.personal.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.personal.hateoas.resource.VideotutorialResource;
import com.personal.model.Videotutorial;
import com.personal.rep.VideotutorialRepository;

@Service
public class VideotutorialServiceImpl implements VideotutorialService {

	@Inject
	private VideotutorialRepository videotutorialRepository;

	@Override
	public VideotutorialResource addvideotutorial(VideotutorialResource videotutorialResource) {
		Videotutorial videotutorial = new Videotutorial();
		videotutorial.setvideoTutorialName(videotutorialResource.getvideotutorialName());
		videotutorial.setvideotutorialDate(videotutorialResource.getvideotutorialDate());
		videotutorial.setvideoTutorialProvider(videotutorialResource.getvideotutorialProvider());
		videotutorial.setDifficultyLevel(videotutorialResource.getDifficultyLevel());
		videotutorial.setvideoTutorialType(videotutorialResource.getvideotutorialType());
		videotutorial.setCertificatePrint(videotutorialResource.isCertificatePrint());
		videotutorial.setRevision(videotutorialResource.isRevision());
		videotutorialRepository.saveAndFlush(videotutorial);

		return videotutorialResource;
	}
}
