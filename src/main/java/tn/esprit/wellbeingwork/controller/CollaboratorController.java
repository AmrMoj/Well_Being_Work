package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.Collaborator;
import tn.esprit.wellbeingwork.service.CollaboratorService;

import java.util.List;
@RestController
@RequestMapping("api/v1/collaborators")
@Api(tags = "Collaborator management")
@AllArgsConstructor
public class CollaboratorController {

    private final CollaboratorService collaboratorService;

    @ApiOperation(value="Add new collaborator")
    @PostMapping("add-collaborator")
    public Collaborator addCollaborator(@RequestBody Collaborator collaborator){
        return collaboratorService.addCollaborator(collaborator);
    }

    @ApiOperation(value = "Get all collaborators")
    @GetMapping("get-all-collaborators")
    public List<Collaborator> retrieveAllCollaborators(){
        return collaboratorService.getAllCollaborators();
    }

    @ApiOperation(value = "Get a collaborator")
    @GetMapping("get-collaborator/{collaboratorId}")
    public Collaborator retrieveCollaborator(@PathVariable("collaboratorId") long id){
        return collaboratorService.retrieveCollaborator(id);
    }
    @ApiOperation(value = "Get a collaborator by user")
    @GetMapping("get-collaborator-by-user}")
    public Collaborator getCollaboratorByUser(){
        return collaboratorService.getCollaboratorByUser();
    }

    @ApiOperation(value = "Delete a collaborator")
    @DeleteMapping("delete-collaborator/{resevationId}")
    public void deleteCollaborator(@PathVariable("resevationId") long id){
        collaboratorService.deleteCollaborator(id);
    }

    @ApiOperation(value = "Update a collaborator")
    @PutMapping("update-collaborator")
    public Collaborator updateCollaborator(@RequestBody Collaborator collaborator){
        return collaboratorService.updateCollaborator(collaborator);
    }
}
