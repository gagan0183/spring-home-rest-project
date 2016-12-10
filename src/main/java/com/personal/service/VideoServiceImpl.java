package com.personal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.model.Video;
import com.personal.rep.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoRepository videoRepository;

	@Override
	public Video addVideo(Video video) {
		return videoRepository.save(video);
	}
}
