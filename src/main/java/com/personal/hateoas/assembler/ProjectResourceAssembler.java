package com.personal.hateoas.assembler;

import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.personal.controller.ProjectController;
import com.personal.hateoas.resource.ProjectResource;
import com.personal.model.Project;

@Component
public class ProjectResourceAssembler extends ResourceAssemblerSupport<Project, ProjectResource> {

	public ProjectResourceAssembler() {
		super(ProjectController.class, ProjectResource.class);
	}

	@Override
	public ProjectResource toResource(Project project) {
		ProjectResource projectResource = createResourceWithId("/project/" + project.getProjectId(), project);
		return projectResource;
	}

	@Override
	public List<ProjectResource> toResources(Iterable<? extends Project> projects) {
		return super.toResources(projects);
	}

	@Override
	protected ProjectResource instantiateResource(Project project) {
		return new ProjectResource(project.getProjectId(), project.getProjectName(), project.getProjectDate(),
				project.getDifficultyLevel(), project.getProjectType(), project.getProjectSource(),
				project.isRevision());
	}

}
