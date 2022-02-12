package com.shahian.springbootcrudwithsqlserver.controller;

import com.shahian.springbootcrudwithsqlserver.domain.Base.BaseDTO;
import com.shahian.springbootcrudwithsqlserver.domain.DTO.ProjectProgresDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ProjectProgres")
public class ProjectProgresController extends BaseController{

    @GetMapping("/getAll")
    public ResponseEntity<?>getAllProjectProgres(){
        BaseDTO baseDTO=projectProgresService.getAllProjectProgres();
        return new ResponseEntity<>(baseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?>getProjectProgres(@PathVariable("id")Long id){
        BaseDTO baseDTO=projectProgresService.getProjectProgresById(id);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?>addProjectProgres(@RequestBody ProjectProgresDTO projectProgresDTO){
        BaseDTO baseDTO=projectProgresService.addProjectProgres(projectProgresDTO);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>aupdateProjectProgres(@PathVariable("id")Long id,@RequestBody ProjectProgresDTO projectProgresDTO){
        BaseDTO baseDTO=projectProgresService.updateProjectProgres(id,projectProgresDTO);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteProjectProgres(@PathVariable("id")Long id){
        BaseDTO baseDTO=projectProgresService.deleteProjectProgres(id);
        return new ResponseEntity<>(baseDTO,HttpStatus.OK);
    }
}
