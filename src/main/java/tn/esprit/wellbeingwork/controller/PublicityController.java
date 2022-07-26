package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.Publicity;
import tn.esprit.wellbeingwork.service.PublicityService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publicitys")
@Api(tags = "Publicity management")
@AllArgsConstructor
public class PublicityController {

    private final PublicityService publicityService;

    @ApiOperation(value="Add new publicity")
    @PostMapping("add-publicity")
    public Publicity addPublicity(@RequestBody Publicity publicity){
        return publicityService.addPublicity(publicity);
    }

    @ApiOperation(value = "Get all publicitys")
    @GetMapping("get-all-publicitys")
    public List<Publicity> retrieveAllPublicitys(){
        return publicityService.getAllPublicitys();
    }

    @ApiOperation(value = "Get a publicity")
    @GetMapping("get-publicity/{publicityId}")
    public Publicity retrievePublicity(@PathVariable("publicityId") long id){
        return publicityService.retrievePublicity(id);
    }


    @ApiOperation(value = "Delete a publicity")
    @DeleteMapping("delete-publicity/{resevationId}")
    public void deletePublicity(@PathVariable("resevationId") long id){
        publicityService.deletePublicity(id);
    }

    @ApiOperation(value = "Update a publicity")
    @PutMapping("update-publicity")
    public Publicity updatePublicity(@RequestBody Publicity publicity){
        return publicityService.updatePublicity(publicity);
    }
}
