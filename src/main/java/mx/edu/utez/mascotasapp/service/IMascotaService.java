package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.model.Mascota;

import java.util.List;

public interface IMascotaService {
    public List<Mascota> findAll();
    public List<Mascota> findByTypeAndStatus(String type, boolean status);
}
