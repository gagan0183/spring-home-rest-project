package com.personal.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.personal.hateoas.resource.VideotutorialResource;
import com.personal.model.Videotutorial;
import com.personal.model.VideotutorialDetail;
import com.personal.rep.VideotutorialDetailRepository;
import com.personal.rep.VideotutorialRepository;

@Service
public class VideotutorialServiceImpl implements VideotutorialService {

	@Inject
	private VideotutorialRepository videotutorialRepository;

	@Inject
	private VideotutorialDetailRepository videotutorialDetailRepository;

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

		for (VideotutorialDetail videotutorialDetail1 : videotutorialResource.getvideotutorialDetail()) {
			VideotutorialDetail videotutorialDetail = new VideotutorialDetail();
			videotutorialDetail.setTutorialName(videotutorialDetail1.getTutorialName());
			videotutorialDetail.setvideotutorial(videotutorial);
			videotutorialDetailRepository.save(videotutorialDetail);
		}

		return videotutorialResource;
	}
}
