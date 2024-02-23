package dev.sbenicio.webappmaxcotas.repository;

import dev.sbenicio.webappmaxcotas.model.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunaRepository extends JpaRepository<Vacuna, Long> {
}
