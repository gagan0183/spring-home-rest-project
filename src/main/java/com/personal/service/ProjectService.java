package com.personal.service;

import com.personal.hateoas.resource.ProjectResource;
import com.personal.model.Project;

public interface ProjectService {
	public Project addProject(ProjectResource projectResource);
}
