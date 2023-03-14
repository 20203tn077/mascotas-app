package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.Repository.ICaracterRepository;
import mx.edu.utez.mascotasapp.model.Caracter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CaracterServiceImpl implements ICaracterService {
    @Autowired
    ICaracterRepository repository;

    @Override
    public List<Caracter> findAll() {
        return repository.findAll();
    }
}
