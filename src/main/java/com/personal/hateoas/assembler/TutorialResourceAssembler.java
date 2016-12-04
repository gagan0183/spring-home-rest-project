package com.personal.hateoas.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.personal.controller.TutorialController;
import com.personal.hateoas.resource.TutorialResource;
import com.personal.model.Tutorial;

@Component
public class TutorialResourceAssembler extends ResourceAssemblerSupport<Tutorial, TutorialResource> {

	public TutorialResourceAssembler() {
		super(TutorialController.class, TutorialResource.class);
	}

	@Override
	public TutorialResource toResource(Tutorial tutorial) {
		TutorialResource tutorialResource = createResourceWithId(tutorial.getTutorialType(), tutorial);
		return tutorialResource;
	}

	@Override
	protected TutorialResource instantiateResource(Tutorial tutorial) {
		return new TutorialResource(tutorial.getTutorialId(), tutorial.getTutorialName(), tutorial.getTutorialType(),
				tutorial.getStartDate(), tutorial.getCompleteDate(), tutorial.isRevision());
	}

	@Override
	public List<TutorialResource> toResources(Iterable<? extends Tutorial> tutorials) {
		List<TutorialResource> tutorialResources = new ArrayList<>();
		for (Tutorial tutorial : tutorials) {
			TutorialResource tutorialResource = createResourceWithId("/tutorial/" + tutorial.getTutorialId(), tutorial);
			tutorialResources.add(tutorialResource);
		}
		return tutorialResources;
	}
}
