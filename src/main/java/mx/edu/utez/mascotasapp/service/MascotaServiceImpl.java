package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.model.Mascota;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class MascotaServiceImpl implements IMascotaService {
    private List<Mascota> pets = null;

    public MascotaServiceImpl(List<Mascota> pets) {
        if (pets != null) fillPets();
    }

    @Override
    public List<Mascota> findAll() {
        return pets;
    }

    @Override
    public boolean save(Mascota pet) {
        pets.add(0, pet);
        return true;
    }

    private void fillPets() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        pets = new LinkedList<>();
        try {
            pets.add(new Mascota(
                    "Pancho",
                    5,
                    "Perro llamado Pancho",
                    "Perro",
                    "perro1.jpg",
                    formatter.parse("03-03-2023"),
                    false
            ));
            pets.add(new Mascota(
                    "Lince",
                    3,
                    "Gato llamado Lince",
                    "Gato",
                    "gato3.jpg",
                    formatter.parse("28-02-2023"),
                    true
            ));
            pets.add(new Mascota(
                    "Galleta",
                    3,
                    "Perro llamado Galleta",
                    "Perro",
                    "perro4.jpg",
                    formatter.parse("26-02-2023"),
                    true
            ));
            pets.add(new Mascota(
                    "Manchas",
                    6,
                    "Gato llamado Manchas",
                    "Gato",
                    "gato1.jpeg",
                    formatter.parse("14-02-2023"),
                    false
            ));
            pets.add(new Mascota(
                    "Sergio",
                    7,
                    "El Serch",
                    "Perro",
                    "perro3.jpeg",
                    formatter.parse("14-02-2023"),
                    true
            ));
            pets.add(new Mascota(
                    "Pelusa",
                    8,
                    "Gato llamado Pelusa",
                    "Gato",
                    "gato2.png",
                    formatter.parse("12-02-2023"),
                    true
            ));
            pets.add(new Mascota(
                    "Manchas 2",
                    6,
                    "Segundo gato llamado Manchas",
                    "Gato",
                    "gato4.png",
                    formatter.parse("09-02-2023"),
                    false
            ));
            pets.add(new Mascota(
                    "Max",
                    6,
                    "Perro llamado Max",
                    "Perro",
                    "perro2.jpg",
                    formatter.parse("01-02-2023"),
                    true
            ));
        } catch (ParseException e) {

        }
    }
}
