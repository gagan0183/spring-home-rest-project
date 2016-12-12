package com.personal.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
