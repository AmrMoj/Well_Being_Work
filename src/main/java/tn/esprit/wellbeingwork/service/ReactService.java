package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.React;

import java.util.List;

public interface ReactService {
    List<React> retrieveAllReacts();

    React addPost(React r);

    void deleteReact(Long id);

    React updateReact(React r);

    React retrieveReact(Long id);
}
