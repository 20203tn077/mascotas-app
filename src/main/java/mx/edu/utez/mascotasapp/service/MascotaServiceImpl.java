package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.model.Mascota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements IMascotaService {
    List<Mascota> pets = null;

    public MascotaServiceImpl(List<Mascota> pets) {
        if (pets != null) fillPets();
    }

    @Override
    public List<Mascota> findAll() {
        return null;
    }

    @Override
    public List<Mascota> findByTypeAndStatus(String type, boolean status) {
        return null;
    }


    private void fillPets() {
        pets.add(new Mascota(
                "Pancho",
                5,
                "Perro llamado Pancho",
                "Perro",
                "perro1.jpg",
                false
        ));
        pets.add(new Mascota(
                "Lince",
                3,
                "Gato llamado Lince",
                "Gato",
                "gato3.jpg",
                true
        ));
        pets.add(new Mascota(
                "Galleta",
                3,
                "Perro llamado Galleta",
                "Perro",
                "perro4.jpg",
                true
        ));
        pets.add(new Mascota(
                "Manchas",
                6,
                "Gato llamado Manchas",
                "Gato",
                "gato1.jpeg",
                false
        ));
        pets.add(new Mascota(
                "Sergio",
                7,
                "El Serch",
                "Perro",
                "perro3.jpeg",
                true
        ));
        pets.add(new Mascota(
                "Pelusa",
                8,
                "Gato llamado Pelusa",
                "Gato",
                "gato2.png",
                true
        ));
        pets.add(new Mascota(
                "Manchas 2",
                6,
                "Segundo gato llamado Manchas",
                "Gato",
                "gato4.png",
                false
        ));
        pets.add(new Mascota(
                "Max",
                6,
                "Perro llamado Max",
                "Perro",
                "perro2.jpg",
                true
        ));
    }
}
