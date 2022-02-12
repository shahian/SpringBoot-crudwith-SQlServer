package com.shahian.springbootcrudwithsqlserver.repository;

import com.shahian.springbootcrudwithsqlserver.domain.entity.ProjectProgres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectProgresRepository extends JpaRepository<ProjectProgres,Long> {
    List<ProjectProgres> findAllByIsDeletedFalse();
    Optional<ProjectProgres> getProjectProgresByIdAndIsDeletedFalse(Long id);
}
