package com.personal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.personal.exception.VideoNotFoundException;
import com.personal.model.Video;
import com.personal.rep.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VideoServiceImpl.class.getPackage().getName());

	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private MessageSource messageSource;

	@Override
	public Video addVideo(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public Video updateVideo(Video video) {
		Video returnVideo = videoRepository.findOne(video.getVideoId());
		if (returnVideo != null) {
			returnVideo.setVideoName(video.getVideoName());
			returnVideo.setSource(video.getSource());
			returnVideo.setGenre(video.getGenre());
			returnVideo.setDate(video.getDate());
			returnVideo.setLink(video.getLink());
			returnVideo.setRevision(video.isRevision());
			returnVideo.setCreatedBy(returnVideo.getCreatedBy());
			returnVideo.setCreatedOn(returnVideo.getCreatedOn());
			returnVideo = videoRepository.save(returnVideo);
		} else {
			throw new VideoNotFoundException(messageSource.getMessage("videonotfoundexception.message", null, null));
		}
		return returnVideo;
	}
}
