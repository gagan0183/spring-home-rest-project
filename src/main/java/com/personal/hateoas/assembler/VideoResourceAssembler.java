package com.personal.hateoas.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.personal.controller.VideoController;
import com.personal.hateoas.resource.VideoResource;
import com.personal.model.Video;

@Component
public class VideoResourceAssembler extends ResourceAssemblerSupport<Video, VideoResource> {

	public VideoResourceAssembler() {
		super(VideoController.class, VideoResource.class);
	}

	@Override
	public VideoResource toResource(Video video) {
		return createResourceWithId("/video/" + video.getVideoId(), video);
	}

	@Override
	public List<VideoResource> toResources(Iterable<? extends Video> videos) {
		return super.toResources(videos);
	}

	@Override
	protected VideoResource instantiateResource(Video video) {
		return new VideoResource(video.getVideoName(), video.getSource(), video.getGenre(), video.getDate(),
				video.getLink(), video.isRevision());
	}
}
