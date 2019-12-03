package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProjectTask;
import com.example.demo.service.ProjectTaskService;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {

	@Autowired
	private ProjectTaskService projectTaskService;
	
	@PostMapping("")
	public ResponseEntity<?> createOrUpdateProjectTask(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
		}
		ProjectTask newPT = projectTaskService.createOrUpdateProjectTask(projectTask);
		return new ResponseEntity<>(newPT, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjectTask> getItem (@PathVariable Long id) {
		ProjectTask newPT = projectTaskService.getItem(id);
		return new ResponseEntity<>(newPT, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<ProjectTask> getAll() {
		return projectTaskService.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable Long id) {
		projectTaskService.deleteItem(id);
		return new ResponseEntity<>("Delete success", HttpStatus.OK);
	}
}
