package com.personal.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.personal.hateoas.resource.ProjectResource;
import com.personal.model.Project;
import com.personal.rep.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class.getPackage().getName());

	@Inject
	private ProjectRepository projectRepository;

	@Override
	public Project addProject(ProjectResource projectResource) {
		LOGGER.info("in addProject");
		Project project = new Project();
		project.setProjectName(projectResource.getProjectName());
		project.setProjectDate(projectResource.getProjectDate());
		project.setDifficultyLevel(projectResource.getDifficultyLevel());
		project.setProjectType(projectResource.getProjectType());
		project.setProjectSource(projectResource.getProjectSource());
		project.setRevision(projectResource.isRevision());
		return projectRepository.save(project);
	}
}
