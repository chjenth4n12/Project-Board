package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.ProjectTask;
import com.example.demo.repository.ProjectTaskRepository;
import com.example.demo.service.ProjectTaskService;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	@Override
	public ProjectTask createOrUpdateProjectTask(ProjectTask projectTask) {
		
		if (StringUtils.isEmpty(projectTask.getStatus())) {
			projectTask.setStatus("TO_DO");
		}
		
		return projectTaskRepository.save(projectTask);
	}

	@Override
	public ProjectTask getItem(Long id) {
		return projectTaskRepository.findAllById(id);
	}

	@Override
	public Iterable<ProjectTask> getAll() {
		return projectTaskRepository.findAll();
	}

	@Override
	public void deleteItem(Long id) {
		projectTaskRepository.deleteById(id);
	}

}
