package mx.edu.utez.mascotasapp.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CaracterServiceImpl implements ICaracterService {
    private List<String> caracteres = null;

    public CaracterServiceImpl() {
        fill();
    }

    @Override
    public List<String> findAll() {
        if (caracteres != null) fill();
        return caracteres;
    }

    private void fill() {
        caracteres = new LinkedList<>();
        caracteres.add("Activo");
        caracteres.add("Independiente");
        caracteres.add("Juguetón");
        caracteres.add("Protector");
        caracteres.add("Ruidoso");
        caracteres.add("Tímido");
        caracteres.add("Tranquilo");
        caracteres.add("Amoroso");
    }
}
