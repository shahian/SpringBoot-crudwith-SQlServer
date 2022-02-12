package com.shahian.springbootcrudwithsqlserver.service;

import com.shahian.springbootcrudwithsqlserver.domain.Base.BaseDTO;
import com.shahian.springbootcrudwithsqlserver.domain.entity.Project;

public interface ProjectService {

    BaseDTO addProject(Project project);

    BaseDTO getAllProjects();

    BaseDTO getProjectsByTopic(String topic);

    BaseDTO getProjectsById(Long id);

    BaseDTO updateProject(Long id,Project project);

    BaseDTO deleteProject(Long id);
}
