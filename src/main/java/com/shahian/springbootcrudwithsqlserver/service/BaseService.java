package com.shahian.springbootcrudwithsqlserver.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shahian.springbootcrudwithsqlserver.repository.ProjectProgresRepository;
import com.shahian.springbootcrudwithsqlserver.repository.ProjectRepository;
import com.shahian.springbootcrudwithsqlserver.utility.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService {
    @Autowired
    protected ApplicationProperties applicationProperties;
    @Autowired
    protected ProjectRepository projectRepository;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected ProjectProgresRepository projectProgresRepository;

}
