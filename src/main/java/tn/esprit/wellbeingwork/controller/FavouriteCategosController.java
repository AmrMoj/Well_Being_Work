package tn.esprit.wellbeingwork.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.pojo.UserFavouriteCategoPOJO;
import tn.esprit.wellbeingwork.service.FavouritesService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("FavCat")
@Api(tags = "Favourite categories management")
public class FavouriteCategosController {

    @Autowired
    FavouritesService favouritesService;

    @ApiOperation(value="Add new favourite categories")
    @PostMapping("addFavCat")
    public ResponseEntity addOrUpdateEventCategosToUser (
            @RequestBody UserFavouriteCategoPOJO userFavouriteCategoPOJO){

        return new ResponseEntity(favouritesService.addOrUpdateEventCategosToUser(userFavouriteCategoPOJO),
                HttpStatus.ACCEPTED);
    }

    @ApiOperation(value="Get users by category")
    @GetMapping("getUsersByCategory/{id-Catego}")
    public ResponseEntity getUsersFavouriteCategos (
            @PathParam("id-Category") Long idCatego ){

        return new ResponseEntity(favouritesService.getUsersFavouriteCategos(idCatego),
                HttpStatus.OK);
    }

    @ApiOperation(value = "Get users having same favourite categories")
    @GetMapping("/getUserSameFavourite/{id-user}")
    public ResponseEntity getPeopleWithSameFavourites(
            @PathParam("id-user") Long idUser){
        return new ResponseEntity((favouritesService.findPeopleWithSameFavourites(idUser)), HttpStatus.OK);
    }

}
