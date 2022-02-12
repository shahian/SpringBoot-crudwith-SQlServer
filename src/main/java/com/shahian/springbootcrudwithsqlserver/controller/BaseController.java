package com.shahian.springbootcrudwithsqlserver.controller;

import com.shahian.springbootcrudwithsqlserver.service.ProjectProgresService;
import com.shahian.springbootcrudwithsqlserver.service.ProjectService;
import com.shahian.springbootcrudwithsqlserver.utility.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseController {
    @Autowired
   protected ProjectService projectService;
    @Autowired
    protected ApplicationProperties applicationProperties;
    @Autowired
    protected ProjectProgresService projectProgresService;


}
