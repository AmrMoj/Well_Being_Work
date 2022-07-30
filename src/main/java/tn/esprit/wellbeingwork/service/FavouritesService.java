package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.EventCatego;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.pojo.UserFavouriteCategoPOJO;

import java.util.List;
import java.util.Set;

public interface FavouritesService {

    User addOrUpdateEventCategosToUser(UserFavouriteCategoPOJO userFavouriteCategoPOJO);

    EventCatego getEventCatego(Long id);

    List<User> getUsersFavouriteCategos(Long id);

    void deleteEventCatego(Long id);

    Set<User> findPeopleWithSameFavourites(Long id);




}
