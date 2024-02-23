package dev.sbenicio.webappmaxcotas.service;

import dev.sbenicio.webappmaxcotas.model.Vacuna;
import dev.sbenicio.webappmaxcotas.repository.VacunaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VacunaService {

    VacunaRepository vacunaRepository;

    public List<Vacuna> listarVacunas(){
        return vacunaRepository.findAll();
    }

    public Vacuna guardarVacuna(Vacuna vacuna){
        return vacunaRepository.save(vacuna);
    }

    public Vacuna obtenerVacunaPorId(Long id){
        return vacunaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la Vacuna: " + id));
    }

    public void eliminarVacuna(Long id){
        vacunaRepository.deleteById(id);
    }




}
