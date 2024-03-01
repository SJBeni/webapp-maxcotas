package dev.sbenicio.webappmaxcotas.controller;

import dev.sbenicio.webappmaxcotas.model.Usuario;
import dev.sbenicio.webappmaxcotas.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {

    private  final CustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public String redireccionarPaginaPrincipal(){
        return "redirect:/mascotas";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model){
        model.addAttribute("usuario", new Usuario());

        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(Usuario usuario){
        customUserDetailsService.guardarUsuario(usuario);

        return "redirect:/login";
    }

    @GetMapping("/gestorRoles")
    public String gestorRoles(Model model) {
        model.addAttribute("usuarios", customUserDetailsService.listarUsuariosRegistrados());
        return "gestorRoles";
    }

}
