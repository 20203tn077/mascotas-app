package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.model.Mascota;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class MascotaServiceImpl implements IMascotaService {
    @Override
    public List<Mascota> findAll() {
        return null;
    }

    @Override
    public boolean save(Mascota pet) {
        return false;
    }
}
