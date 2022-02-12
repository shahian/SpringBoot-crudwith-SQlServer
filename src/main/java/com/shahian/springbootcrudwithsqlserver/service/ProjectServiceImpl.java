package com.shahian.springbootcrudwithsqlserver.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shahian.springbootcrudwithsqlserver.domain.Base.BaseDTO;
import com.shahian.springbootcrudwithsqlserver.domain.Base.MetaDTO;
import com.shahian.springbootcrudwithsqlserver.domain.DTO.ProjectDTO;
import com.shahian.springbootcrudwithsqlserver.domain.entity.Project;
import com.shahian.springbootcrudwithsqlserver.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl extends BaseService implements ProjectService {

    @Override
    @Transactional
    public BaseDTO addProject(Project project) {
        Project project1 = Project.builder()
                .topic(project.getTopic())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .createDateTime(new Timestamp(System.currentTimeMillis()))
                .isDeleted(false)
                .build();
        projectRepository.save(project1);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), project1);
    }

    @Override
    public BaseDTO getAllProjects() {
        List<Project> projectList = new ArrayList<Project>();
        projectList = projectRepository.findAllByIsDeletedFalse();
        List<ProjectDTO> projectDTOs = objectMapper.convertValue(projectList, new TypeReference<List<ProjectDTO>>() {
        });
        //List<ProjectDTO>projectDTOs= Arrays.stream(new ObjectMapper().convertValue(projectList, ProjectDTO[].class)).collect(Collectors.toList());
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), projectDTOs);
    }

    @Override
    public BaseDTO getProjectsByTopic(String topic) {
        List<Project> projectList = new ArrayList<>();
        projectList = projectRepository.findProjectByTopicAndIsDeletedFalse(topic);
        List<ProjectDTO> projectDTOs = new ObjectMapper().convertValue(projectList, new TypeReference<List<ProjectDTO>>() {
        });
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), projectDTOs);
    }

    @Override
    public BaseDTO getProjectsById(Long id) {
       /* Optional<Project> project = projectRepository.findByIdAndIsDeletedFalse(id);
        if (project.isPresent()) {
            ProjectDTO projectDTO = new ObjectMapper().convertValue(project, ProjectDTO.class);
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), projectDTO);
        } else {
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), HttpStatus.NOT_FOUND);
        }*/
        Project project = projectRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text") + id));
        ProjectDTO projectDTO = new ObjectMapper().convertValue(project, ProjectDTO.class);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), projectDTO);
    }

    @Override
    @Transactional
    public BaseDTO updateProject(Long id, Project projectview) {
        Project project = projectRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text") + id));

        Project newProject = project;
        newProject.setTopic(projectview.getTopic());
        newProject.setStartDate(projectview.getStartDate());
        newProject.setEndDate(projectview.getEndDate());
        newProject.setModifyDateTime(new Timestamp(System.currentTimeMillis()));

        projectRepository.save(newProject);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), newProject);

    }

    @Override
    public BaseDTO deleteProject(Long id) {
        Optional<Project> project = projectRepository.findByIdAndIsDeletedFalse(id);
        if (project.isPresent()) {
            Project project1 = project.get();
            project1.setIsDeleted(true);
            project1.setModifyDateTime(new Timestamp(System.currentTimeMillis()));

            projectRepository.save(project1);
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), project1);
        } else {
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), HttpStatus.NOT_FOUND);

        }
    }
}
