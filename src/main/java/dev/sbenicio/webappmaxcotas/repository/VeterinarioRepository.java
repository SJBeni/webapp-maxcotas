package dev.sbenicio.webappmaxcotas.repository;

import dev.sbenicio.webappmaxcotas.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
