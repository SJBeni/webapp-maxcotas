package dev.sbenicio.webappmaxcotas.controller;

import dev.sbenicio.webappmaxcotas.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class AuthController {

    private  final CustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public String redireccionarPaginaPrincipal(){
        return "redirect:/mascotas";
    }


}
