package com.techdotsanjs.kanbantoolapi.service;

import com.techdotsanjs.kanbantoolapi.model.Project;
import com.techdotsanjs.kanbantoolapi.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Iterable<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(String projectId) {
        return projectRepository.findById(Long.valueOf(projectId)).orElseThrow(() -> new EntityNotFoundException(projectId));

    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project project) {
        System.out.println(project);
        return projectRepository.save(project);
    }


}
