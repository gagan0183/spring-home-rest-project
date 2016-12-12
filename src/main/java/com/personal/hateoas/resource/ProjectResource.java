package com.personal.hateoas.resource;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

public class ProjectResource extends ResourceSupport {
	private int projectId;
	private String projectName;
	private Date projectDate;
	private String difficultyLevel;
	private String projectType;
	private String projectSource;
	private boolean revision;

	public ProjectResource() {

	}

	public ProjectResource(int projectId, String projectName, Date projectDate, String difficultyLevel,
			String projectType, String projectSource, boolean revision) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDate = projectDate;
		this.difficultyLevel = difficultyLevel;
		this.projectType = projectType;
		this.projectSource = projectSource;
		this.revision = revision;
	}

	public int getProjectId() {
		return projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public Date getProjectDate() {
		return projectDate;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public String getProjectType() {
		return projectType;
	}

	public String getProjectSource() {
		return projectSource;
	}

	public boolean isRevision() {
		return revision;
	}
}
