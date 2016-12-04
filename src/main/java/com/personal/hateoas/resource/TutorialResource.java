package com.personal.hateoas.resource;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

public class TutorialResource extends ResourceSupport {
	private int tutorial_id;
	private String tutorial_name;
	private String tutorial_type;
	private Date startDate;
	private Date completeDate;
	private boolean revision;

	public TutorialResource() {

	}

	public TutorialResource(int tutorial_id, String tutorial_name, String tutorial_type, Date startDate,
			Date completeDate, boolean revision) {
		super();
		this.tutorial_id = tutorial_id;
		this.tutorial_name = tutorial_name;
		this.tutorial_type = tutorial_type;
		this.startDate = startDate;
		this.completeDate = completeDate;
		this.revision = revision;
	}

	public int getTutorial_id() {
		return tutorial_id;
	}

	public String getTutorial_name() {
		return tutorial_name;
	}

	public String getTutorial_type() {
		return tutorial_type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public boolean isRevision() {
		return revision;
	}
}
