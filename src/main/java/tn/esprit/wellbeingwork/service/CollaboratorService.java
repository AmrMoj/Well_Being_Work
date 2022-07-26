package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Collaborator;
import tn.esprit.wellbeingwork.entity.Comment;

import java.util.List;

public interface CollaboratorService {
    List<Collaborator> getAllCollaborators();

    Collaborator addCollaborator(Collaborator collaborator);

    void deleteCollaborator(Long id);

    Collaborator updateCollaborator(Collaborator collaborator);

    Collaborator retrieveCollaborator(Long id);
    Collaborator getCollaboratorByUser();

}
