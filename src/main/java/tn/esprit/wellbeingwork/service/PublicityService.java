package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Publicity;

import java.util.List;

public interface PublicityService {
    List<Publicity> getAllPublicitys();

    Publicity addPublicity(Publicity publicity);

    void deletePublicity(Long id);

    Publicity updatePublicity(Publicity publicity);

    Publicity retrievePublicity(Long id);

}
