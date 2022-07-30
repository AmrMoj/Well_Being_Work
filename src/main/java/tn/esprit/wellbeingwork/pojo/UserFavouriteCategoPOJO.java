package tn.esprit.wellbeingwork.pojo;

import java.util.Vector;

public class UserFavouriteCategoPOJO {

    private long idUser;
    private Vector<Long> favouriteCategoriesId;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public Vector<Long> getFavouriteCategoriesId() {
        return favouriteCategoriesId;
    }

    public void setFavouriteCategoriesId(Vector<Long> favouriteCategoriesId) {
        this.favouriteCategoriesId = favouriteCategoriesId;
    }
}
