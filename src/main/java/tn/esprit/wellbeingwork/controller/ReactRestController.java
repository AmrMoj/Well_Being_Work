package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.React;
import tn.esprit.wellbeingwork.service.ReactService;

import java.util.List;

@RestController
@RequestMapping("react")
@Api(tags = "React management")
public class ReactRestController {

    @Autowired
    ReactService reactService;

    @ApiOperation(value="Add new react")
    @PostMapping("addReact")
    public React addReact(@RequestBody React react){
        return reactService.addPost(react);
    }

    @ApiOperation(value = "Get all reacts")
    @GetMapping("getAllReacts")
    public List<React> retrieveAllReacts(){
        return reactService.retrieveAllReacts();
    }

    @ApiOperation(value = "Get a react")
    @GetMapping("getReact/{reactId}")
    public React retrieveReact(@PathVariable("reactId") long id){
        return reactService.retrieveReact(id);
    }

    @ApiOperation(value = "Delete a react")
    @DeleteMapping("deleteReact/{reactId}")
    public void deleteReact(@PathVariable("reactId") long id){
        reactService.deleteReact(id);
    }

    @ApiOperation(value = "Update a react")
    @PutMapping("updateReact")
    public React updatePost(@RequestBody React react){
        return reactService.updateReact(react);
    }
}
