package com.example.demo.service;

import com.example.demo.entity.ProjectTask;

public interface ProjectTaskService {

	public ProjectTask createOrUpdateProjectTask (ProjectTask projectTask);
	
	public ProjectTask getItem (Long id);
	
	public Iterable<ProjectTask> getAll ();
	
	public void deleteItem (Long id);
}
