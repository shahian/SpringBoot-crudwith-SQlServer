package com.shahian.springbootcrudwithsqlserver.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.shahian.springbootcrudwithsqlserver.domain.Base.BaseDTO;
import com.shahian.springbootcrudwithsqlserver.domain.Base.MetaDTO;
import com.shahian.springbootcrudwithsqlserver.domain.DTO.ProjectProgresDTO;
import com.shahian.springbootcrudwithsqlserver.domain.entity.ProjectProgres;
import com.shahian.springbootcrudwithsqlserver.exception.GlobalExceptionHandler;
import com.shahian.springbootcrudwithsqlserver.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectProgresServiceImpl extends BaseService implements ProjectProgresService {
    @Override
    public BaseDTO getAllProjectProgres() {
        try {
            List<ProjectProgres> projectProgres = new ArrayList<>();
            projectProgres = projectProgresRepository.findAllByIsDeletedFalse();
            List<ProjectProgresDTO> projectProgresDTOS = objectMapper.convertValue(projectProgres,
                    new TypeReference<List<ProjectProgresDTO>>() {
                    });
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), projectProgresDTOS);
        } catch (Exception ex) {
            throw new GlobalExceptionHandler(applicationProperties.getProperty("application.message.exceptionError.text"));

        }

    }

    @Override
    public BaseDTO getProjectProgresById(Long id) {
        ProjectProgres projectProgres = projectProgresRepository.getProjectProgresByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text")));
        ProjectProgresDTO projectProgresDTO = objectMapper.convertValue(projectProgres, ProjectProgresDTO.class);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), projectProgresDTO);
    }

    @Override
    @Transactional
    public BaseDTO addProjectProgres(ProjectProgresDTO projectProgresDTO) {
        try {
            ProjectProgres projectProgres = new ProjectProgres();
            projectProgres.setIsDeleted(false);
            projectProgres.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
            projectProgres.setYearId(projectProgresDTO.getYearId());
            projectProgres.setMonthId(projectProgresDTO.getMonthId());
            projectProgres.setTypeOfProjectProgresId(projectProgresDTO.getMonthId());
            projectProgres.setReal(projectProgresDTO.getReal());
            projectProgres.setProgram(projectProgresDTO.getProgram());
            projectProgres.setPercentageOfDeviation(projectProgresDTO.getPercentageOfDeviation());
            projectProgres.setProjectId(projectProgresDTO.getProjectId());
            projectProgresRepository.save(projectProgres);
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), projectProgres);
        } catch (Exception ex) {
            throw new GlobalExceptionHandler(applicationProperties.getProperty("application.message.exceptionError.text"));
        }
    }


    @Override
    @Transactional
    public BaseDTO updateProjectProgres(Long id, ProjectProgresDTO projectProgresDTO) {
        try {
            ProjectProgres projectProgres = projectProgresRepository.getProjectProgresByIdAndIsDeletedFalse(id)
                    .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text")));
            ProjectProgres updateProgres = projectProgres;
            updateProgres.setProjectId(projectProgresDTO.getProjectId());
            updateProgres.setYearId(projectProgresDTO.getYearId());
            updateProgres.setMonthId(projectProgresDTO.getMonthId());
            updateProgres.setReal(projectProgresDTO.getReal());
            updateProgres.setTypeOfProjectProgresId(projectProgresDTO.getTypeOfProjectProgresId());
            updateProgres.setPercentageOfDeviation(projectProgresDTO.getPercentageOfDeviation());
            updateProgres.setModifyDateTime(new Timestamp(System.currentTimeMillis()));
            projectProgres.setCreateDateTime(projectProgresDTO.getCreateDateTime());
            projectProgres.setIsDeleted(projectProgresDTO.getIsDeleted());
            projectProgresRepository.save(updateProgres);
            return new BaseDTO(MetaDTO.getInstance(applicationProperties), updateProgres);
        } catch (Exception ex) {
            throw new GlobalExceptionHandler(applicationProperties.getProperty("application.message.exceptionError.text"+ex.getMessage()));
        }
    }

    @Override
    public BaseDTO deleteProjectProgres(Long id) {
        ProjectProgres progres = projectProgresRepository.getProjectProgresByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(applicationProperties.getProperty("application.message.notfound.text")));
        progres.setIsDeleted(true);
        progres.setModifyDateTime(new Timestamp(System.currentTimeMillis()));
        projectProgresRepository.save(progres);
        return new BaseDTO(MetaDTO.getInstance(applicationProperties), progres);
    }
}