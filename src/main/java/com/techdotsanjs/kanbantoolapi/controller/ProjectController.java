package com.techdotsanjs.kanbantoolapi.controller;

import com.techdotsanjs.kanbantoolapi.util.RequestValidator;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import com.techdotsanjs.kanbantoolapi.model.Project;
import com.techdotsanjs.kanbantoolapi.service.ProjectService;

@RestController
@RequestMapping("api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult bindingResult) {
        HashMap<String, String> errorMap = RequestValidator.getErrorMap(bindingResult);
        if (errorMap != null) return ResponseEntity.badRequest().body(errorMap);
        return ResponseEntity.ok().body(projectService.saveProject(project));
    }

    @PutMapping
    public ResponseEntity<?> updateProject(@Valid @RequestBody Project project, BindingResult bindingResult) {
        HashMap<String, String> errorMap = RequestValidator.getErrorMap(bindingResult);
        if (errorMap != null) return ResponseEntity.badRequest().body(errorMap);
        return ResponseEntity.ok().body(projectService.updateProject(project));
    }

    @GetMapping
    public ResponseEntity<Iterable<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable String projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId));
    }


}
