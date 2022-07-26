package tn.esprit.wellbeingwork.service.implementation;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tn.esprit.wellbeingwork.entity.Collaborator;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.repository.CollaboratorRepository;
import tn.esprit.wellbeingwork.repository.UserRepository;
import tn.esprit.wellbeingwork.service.CollaboratorService;

import java.util.List;

@Service
@AllArgsConstructor
public class CollaboratorServiceImpl implements CollaboratorService {
    private final CollaboratorRepository collaboratorRepository;
    private final UserRepository userRepository;

    @Override
    public List<Collaborator> getAllCollaborators() {
        return collaboratorRepository.findAll();
    }

    @Override
    public Collaborator addCollaborator(Collaborator collaborator) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalStateException("User doesnt exists"));
        collaborator.setUser(user);
        return collaboratorRepository.save(collaborator);
    }

    @Override
    public void deleteCollaborator(Long id) {
        collaboratorRepository.deleteById(id);
    }

    @Override
    public Collaborator updateCollaborator(Collaborator collaborator) {

        return collaboratorRepository.save(collaborator);
    }

    @Override
    public Collaborator retrieveCollaborator(Long id) {
        return collaboratorRepository.findById(id).orElseThrow(() -> new IllegalStateException("Collaborator doesnt exist"));
    }

    @Override
    public Collaborator getCollaboratorByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collaborator collaborator = new Collaborator();
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalStateException("User doesnt exists"));
        if (user != null) {
            collaborator = collaboratorRepository.findByUser(user);
        }
        return collaborator;
    }
}
