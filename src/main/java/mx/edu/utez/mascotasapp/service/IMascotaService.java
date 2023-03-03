package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.model.Mascota;

import java.util.List;

public interface IMascotaService {
    List<Mascota> findAll();

    boolean save(Mascota pet);
}
