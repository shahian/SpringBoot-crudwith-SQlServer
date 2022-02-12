package com.shahian.springbootcrudwithsqlserver.repository;

import com.shahian.springbootcrudwithsqlserver.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findProjectByTopic(String topic);

    List<Project> findAllByIsDeletedFalse();

    Optional<Project> findByIdAndIsDeletedFalse(long id);

    List<Project> findProjectByTopicAndIsDeletedFalse(String topic);
}
