package tn.esprit.wellbeingwork.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.wellbeingwork.entity.React;
import tn.esprit.wellbeingwork.repository.ReactRepository;
import tn.esprit.wellbeingwork.service.ReactService;

import java.util.List;

@Service
@Slf4j
public class ReactServiceImpl implements ReactService {

    @Autowired
    ReactRepository reactRepository;

    @Override
    public List<React> retrieveAllReacts() {
        return reactRepository.findAll();
    }

    @Override
    public React addPost(React r) {
        return reactRepository.save(r);
    }

    @Override
    public void deleteReact(Long id) {
        reactRepository.deleteById(id);
    }

    @Override
    public React updateReact(React r) {
        return reactRepository.save(r);
    }

    @Override
    public React retrieveReact(Long id) {
        return reactRepository.findById(id).get();
    }
}
