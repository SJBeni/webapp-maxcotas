package dev.sbenicio.webappmaxcotas.service;

import dev.sbenicio.webappmaxcotas.model.Mascota;
import dev.sbenicio.webappmaxcotas.model.Veterinario;
import dev.sbenicio.webappmaxcotas.repository.MascotaRepository;
import dev.sbenicio.webappmaxcotas.repository.VacunaRepository;
import dev.sbenicio.webappmaxcotas.repository.VeterinarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MascotaService {

    private MascotaRepository mascotaRepository;
    private VeterinarioRepository veterinarioRepository;
    private VacunaRepository vacunaRepository;

    public Mascota obtenerMascotaPorId(Long id){
        return mascotaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la Mascota"));
    }

    public List<Mascota> listarMascotas(){
        return mascotaRepository.findAllByOrderByNombreIgnoreCaseAsc();
    }

    public Mascota guardarMascota(Mascota mascota, Long idVeterinario, List<Long> idVacunas ){
        Veterinario veterinario = veterinarioRepository.findById(idVeterinario).orElseThrow(() -> new RuntimeException("No se encontro el " +
                "veterinario (" + idVeterinario + ") al momento de guardar la mascota"));
        mascota.setVeterinario(veterinario);

        if (idVacunas != null){
            mascota.setVacunasAplicadas(vacunaRepository.findAllById(idVacunas));
        }

        return mascotaRepository.save(mascota);
    }


}
