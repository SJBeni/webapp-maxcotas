package dev.sbenicio.webappmaxcotas;

import dev.sbenicio.webappmaxcotas.model.Veterinario;
import dev.sbenicio.webappmaxcotas.service.VeterinarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VeterinarioTest {

    @Autowired
    private VeterinarioService veterinarioService;

    private Veterinario veterinarioGuardado;

    @BeforeEach
    void setUp(){
        Veterinario veterinario = new Veterinario();
        veterinario.setNombre("Dr. Juan Diaz");
        veterinario.setMatricula("ASD123");
        veterinario.setEmail("drjuandiaz@example.com");

        veterinarioGuardado = veterinarioService.guardarVeterinario(veterinario);
    }

    @Test
    void testGuardarVeterinario(){
        assertNotNull(veterinarioGuardado.getId());
        assertEquals("Dr. Juan Diaz", veterinarioGuardado.getNombre());
        assertEquals("ASD123", veterinarioGuardado.getMatricula());
        assertEquals("drjuandiaz@example.com", veterinarioGuardado.getEmail());
    }

    @Test
    void testListarVeterinario(){
        List<Veterinario> veterinarios = veterinarioService.listarVeterinarios();
        assertFalse(veterinarios.isEmpty());
    }

    @Test
    void testObtenerVeterinarioPorId(){
        Long veterinarioId = 1L;
        Veterinario veterinario = veterinarioService.obtenerVeterinarioPorId(veterinarioId);

        assertNotNull(veterinario);
        assertEquals(veterinarioId, veterinario.getId());
    }
}
