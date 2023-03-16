package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.Repository.IMascotaRepository;
import mx.edu.utez.mascotasapp.model.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class MascotaServiceImpl implements IMascotaService {
    @Autowired
    IMascotaRepository repository;

    @Override
    public List<Mascota> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean save(Mascota pet) {
        repository.save(pet);
        return true;
    }
}
