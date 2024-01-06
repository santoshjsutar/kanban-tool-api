package com.techdotsanjs.kanbantoolapi.repository;

import com.techdotsanjs.kanbantoolapi.model.Project;
import com.techdotsanjs.kanbantoolapi.payload.ProjectResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>, ListPagingAndSortingRepository<Project, Long>, PagingAndSortingRepository<Project, Long> {

}
