package dev.sbenicio.webappmaxcotas.repository;

import dev.sbenicio.webappmaxcotas.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    Optional<Mascota> findByNombre(String nombre);

    @Query("SELECT m FROM Mascota m ORDER BY LOWER(m.nombre) ASC")
    List<Mascota> findAllByOrderByNombreIgnoreCaseAsc();
}
