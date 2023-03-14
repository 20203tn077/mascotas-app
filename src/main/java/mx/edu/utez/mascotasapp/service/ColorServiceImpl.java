package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.Repository.IColorRepository;
import mx.edu.utez.mascotasapp.model.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ColorServiceImpl implements IColorService {

    @Autowired
    IColorRepository repository;

    @Override
    public List<Color> findAll() {
        return repository.findAll();
    }
}
