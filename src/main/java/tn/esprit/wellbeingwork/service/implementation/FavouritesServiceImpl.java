package tn.esprit.wellbeingwork.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.esprit.wellbeingwork.controller.exception.NoDataFoundException;
import tn.esprit.wellbeingwork.entity.EventCatego;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.pojo.UserFavouriteCategoPOJO;
import tn.esprit.wellbeingwork.repository.EventCategoRepository;
import tn.esprit.wellbeingwork.repository.UserRepository;
import tn.esprit.wellbeingwork.service.FavouritesService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class FavouritesServiceImpl implements FavouritesService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventCategoRepository eventCategoRepository;

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(NoDataFoundException::new);
    }

    public EventCatego findCategoryById(Long id){
        return eventCategoRepository.findById(id).orElseThrow(NoDataFoundException::new);
    }

    @Override
    public User addOrUpdateEventCategosToUser(UserFavouriteCategoPOJO userFavouriteCategoPOJO) {
        User user = findUserById(userFavouriteCategoPOJO.getIdUser());
        List<EventCatego> eventCategos = new ArrayList<>();
        userFavouriteCategoPOJO.getFavouriteCategoriesId().forEach(
                categoryId -> {
                    eventCategos.add(
                        findCategoryById(categoryId)
                    );
                });
        user.setEventCategos(eventCategos);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsersFavouriteCategos(Long id) {
        return findCategoryById(id).getUsers();
    }

    @Override
    public Set<User> findPeopleWithSameFavourites(Long id) {
        User user=findUserById(id);
        Set<User> users=new HashSet<>();
        user.getEventCategos().forEach(
                cat->{
                   users.addAll(getUsersFavouriteCategos(cat.getIdEventCatego()));
                }
        );
            return users;
        }

    @Override
    public EventCatego getEventCatego(Long id) {
        return null;
    }

    @Override
    public void deleteEventCatego(Long id) {  }





}
