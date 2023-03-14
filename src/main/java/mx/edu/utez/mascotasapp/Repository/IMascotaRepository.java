package mx.edu.utez.mascotasapp.Repository;

import mx.edu.utez.mascotasapp.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findAll();
}
