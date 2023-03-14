package mx.edu.utez.mascotasapp.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ColorServiceImpl implements IColorService {

    private List<String> colores = null;

    public ColorServiceImpl() {
        fill();
    }

    @Override
    public List<String> findAll() {
        if (colores != null) fill();
        return colores;
    }

    private void fill() {
        colores = new LinkedList<>();
        colores.add("Blanco");
        colores.add("Café");
        colores.add("Gris");
        colores.add("Negro");
        colores.add("Atigrado");
        colores.add("Bicolor");
        colores.add("Con manchas");
        colores.add("Varios colares");
    }
}
