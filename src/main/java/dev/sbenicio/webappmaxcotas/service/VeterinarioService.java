package dev.sbenicio.webappmaxcotas.service;

import dev.sbenicio.webappmaxcotas.model.Veterinario;
import dev.sbenicio.webappmaxcotas.repository.VacunaRepository;
import dev.sbenicio.webappmaxcotas.repository.VeterinarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VeterinarioService {

    private VeterinarioRepository veterinarioRepository;


    public Veterinario obtenerVeterinarioPorId(Long id){
        return veterinarioRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el Veterinario"));
    }

    public List<Veterinario> listarVeterinarios(){
        return veterinarioRepository.findAll();
    }

    public Veterinario guardarVeterinario(Veterinario veterinario){
        return veterinarioRepository.save(veterinario);
    }

}
