package dev.sbenicio.webappmaxcotas.controller;

import dev.sbenicio.webappmaxcotas.model.Mascota;
import dev.sbenicio.webappmaxcotas.model.Veterinario;
import dev.sbenicio.webappmaxcotas.service.MascotaService;
import dev.sbenicio.webappmaxcotas.service.VacunaService;
import dev.sbenicio.webappmaxcotas.service.VeterinarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class MascotaViewController {

    private final MascotaService mascotaService;
    private final VeterinarioService veterinarioService;
    private final VacunaService vacunaService;

    @GetMapping("/")
    public String redireccionarPaginaPrincipal(){
        return "redirect:/mascotas";
    }
    @GetMapping("/mascotas")
    public String listarMascotas(Model model){
        List<Mascota> mascotas = mascotaService.listarMascotas();
        model.addAttribute("mascotas", mascotas);

        return "mascotas";
    }

    @GetMapping("/agregarMascota")
    public String mostrarFormularioAgregarMascota(Model model){
        model.addAttribute("veterinarios", veterinarioService.listarVeterinarios());
        model.addAttribute("vacunas", vacunaService.listarVacunas());
        model.addAttribute("mascota", new Mascota());

        return "agregarMascota";
    }

    @PostMapping("/guardarMascota")
    public String guardarMascota(@ModelAttribute Mascota mascota, @RequestParam Long idVeterinario, @RequestParam(required = false) List<Long> idVacunas){
        mascotaService.guardarMascota(mascota, idVeterinario, idVacunas);

        return "redirect:/mascotas";
    }

    @GetMapping("/actualizarMascota/{id}")
    public String mostrarFormularioActualizarMascota(@PathVariable Long id, Model model){
        Mascota mascota = mascotaService.obtenerMascotaPorId(id);
        model.addAttribute("mascota", mascota);
        model.addAttribute("veterinarios", veterinarioService.listarVeterinarios());
        model.addAttribute("vacunas", vacunaService.listarVacunas());

        return "actualizarMascota";
    }

    @PostMapping("/actualizarMascota/{idMascota}")
    public String actualizarMascota(@PathVariable Long idMascota, @ModelAttribute Mascota mascotaActualizada, @RequestParam Long idVeterinario, @RequestParam(required = false) List<Long> idVacunas){
        mascotaService.actualizarMascota(idMascota, mascotaActualizada, idVeterinario, idVacunas);

        return "redirect:/mascotas";
    }


    @GetMapping("/eliminarMascota/{id}")
    public String eliminarMascota(@PathVariable Long id){
        mascotaService.eliminarMascota(id);

        return "redirect:/mascotas";
    }
}














