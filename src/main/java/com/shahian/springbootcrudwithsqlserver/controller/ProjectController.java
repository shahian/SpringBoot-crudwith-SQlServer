package com.shahian.springbootcrudwithsqlserver.controller;

import com.shahian.springbootcrudwithsqlserver.domain.Base.BaseDTO;
import com.shahian.springbootcrudwithsqlserver.domain.entity.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController extends BaseController{

    @GetMapping("/getAll")
    public ResponseEntity<?>getAllProjects(String topic){
        try{
            if (topic==null){
                BaseDTO baseDTO= projectService.getAllProjects();
                return new ResponseEntity<>(baseDTO,HttpStatus.OK);
            }else{
                BaseDTO baseDTO= projectService.getProjectsByTopic(topic);
                return new ResponseEntity<>(baseDTO,HttpStatus.OK);
            }

        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?>getProjectById(@PathVariable("id")long id){
        BaseDTO baseDTO= projectService.getProjectsById(id);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
@PostMapping(value = "/add")
    public ResponseEntity<?>save(@RequestBody Project project){
    BaseDTO baseDTO= projectService.addProject(project);
    return new  ResponseEntity<>(baseDTO,HttpStatus.CREATED);
}
@PutMapping("/update/{id}")
    public ResponseEntity<?>updateProject(@PathVariable("id")long id,@RequestBody Project project){
        BaseDTO baseDTO=projectService.updateProject(id,project);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
}
@DeleteMapping("delete/{id}")
    public ResponseEntity<?>deleteProject(@PathVariable("id")long id){
        try{
            BaseDTO baseDTO=projectService.deleteProject(id);
            return new ResponseEntity<>(baseDTO,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

}
