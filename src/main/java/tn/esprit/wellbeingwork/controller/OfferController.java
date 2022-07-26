package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.Offer;
import tn.esprit.wellbeingwork.service.OfferService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
@Api(tags = "Offer management")
@AllArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @ApiOperation(value="Add new offer")
    @PostMapping("add-offer")
    public Offer addOffer(@RequestBody Offer offer){
        return offerService.addOffer(offer);
    }

    @ApiOperation(value = "Get all offers")
    @GetMapping("get-all-offers")
    public List<Offer> retrieveAllOffers(){
        return offerService.getAllOffers();
    }

    @ApiOperation(value = "Get a offer")
    @GetMapping("get-offer/{offerId}")
    public Offer retrieveOffer(@PathVariable("offerId") long id){
        return offerService.getOffer(id);
    }


    @ApiOperation(value = "Delete a offer")
    @DeleteMapping("delete-offer/{offerId}")
    public void deleteOffer(@PathVariable("offerId") long id){
        offerService.deleteOffer(id);
    }

    @ApiOperation(value = "Update a offer")
    @PutMapping("update-offer")
    public Offer updateOffer(@RequestBody Offer offer){
        return offerService.updateOffer(offer);
    }
}
