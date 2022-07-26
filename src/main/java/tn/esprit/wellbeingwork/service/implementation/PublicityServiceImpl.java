package tn.esprit.wellbeingwork.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tn.esprit.wellbeingwork.entity.Publicity;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.repository.PublicityRepository;
import tn.esprit.wellbeingwork.repository.UserRepository;
import tn.esprit.wellbeingwork.service.PublicityService;

import java.util.List;

@Service
@AllArgsConstructor
public class PublicityServiceImpl implements PublicityService {
    private final PublicityRepository publicityRepository;
    private final UserRepository userRepository;

    @Override
    public List<Publicity> getAllPublicitys() {
        return publicityRepository.findAll();
    }

    @Override
    public Publicity addPublicity(Publicity publicity) {

        return publicityRepository.save(publicity);
    }

    @Override
    public void deletePublicity(Long id) {
        publicityRepository.deleteById(id);
    }

    @Override
    public Publicity updatePublicity(Publicity publicity) {
        return publicityRepository.save(publicity);
    }

    @Override
    public Publicity retrievePublicity(Long id) {
        return publicityRepository.findById(id).orElseThrow(() -> new IllegalStateException("Publicity doesnt exists"));
    }


}
