package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.Repository.ITamanoRepository;
import mx.edu.utez.mascotasapp.model.Tamano;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TamanoService implements ITamanoService{
    @Autowired
    ITamanoRepository repository;

    @Override
    public List<Tamano> findAll() {
        return repository.findAll();
    }
}
