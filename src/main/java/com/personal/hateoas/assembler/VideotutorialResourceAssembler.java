package com.personal.hateoas.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.personal.controller.VideotutorialController;
import com.personal.hateoas.resource.VideotutorialResource;
import com.personal.model.Videotutorial;

@Component
public class VideotutorialResourceAssembler extends ResourceAssemblerSupport<Videotutorial, VideotutorialResource> {

	public VideotutorialResourceAssembler() {
		super(VideotutorialController.class, VideotutorialResource.class);
	}

	@Override
	public VideotutorialResource toResource(Videotutorial videotutorial) {
		VideotutorialResource videotutorialResource = createResourceWithId(
				"/videotutorial/" + videotutorial.getvideoTutorialId(), videotutorial);
		return videotutorialResource;
	}

	@Override
	protected VideotutorialResource instantiateResource(Videotutorial videotutorial) {
		return new VideotutorialResource(videotutorial.getvideotutorialName(), videotutorial.getvideotutorialDate(),
				videotutorial.getvideotutorialProvider(), videotutorial.getDifficultyLevel(),
				videotutorial.getvideotutorialType(), videotutorial.isCertificatePrint(),
				videotutorial.isRevision());
	}
}
