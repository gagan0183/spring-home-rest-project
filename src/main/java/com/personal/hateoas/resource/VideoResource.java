package com.personal.hateoas.resource;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

public class VideoResource extends ResourceSupport {
	private String videoName;
	private String source;
	private String genre;
	private Date date;
	private String link;
	private boolean revision;

	public VideoResource() {

	}

	public VideoResource(String videoName, String source, String genre, Date date, String link, boolean revision) {
		super();
		this.videoName = videoName;
		this.source = source;
		this.genre = genre;
		this.date = date;
		this.link = link;
		this.revision = revision;
	}

	public String getVideoName() {
		return videoName;
	}

	public String getSource() {
		return source;
	}

	public String getGenre() {
		return genre;
	}

	public Date getDate() {
		return date;
	}

	public boolean isRevision() {
		return revision;
	}

	public String getLink() {
		return link;
	}
}
