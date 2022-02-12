package com.shahian.springbootcrudwithsqlserver.service;

import com.shahian.springbootcrudwithsqlserver.domain.Base.BaseDTO;
import com.shahian.springbootcrudwithsqlserver.domain.DTO.ProjectProgresDTO;

public interface ProjectProgresService{
    BaseDTO getAllProjectProgres();

    BaseDTO getProjectProgresById(Long id);

    BaseDTO addProjectProgres(ProjectProgresDTO projectProgresDTO);

    BaseDTO updateProjectProgres(Long id, ProjectProgresDTO projectProgresDTO);

    BaseDTO deleteProjectProgres(Long id);
}
