package dev.sbenicio.webappmaxcotas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data   //toString, equals, hashcode, getters y setters
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "El Nombre NO puede estar en blanco")
    private String nombre;

    @NotBlank(message = "La Matricula NO puede estar en blanco")
    private String matricula;

    @NotBlank(message = "El email NO puede estar en blanco")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "El formato del Email no es valido")
    private String email;

    @OneToMany(mappedBy = "veterinario", fetch = FetchType.EAGER)
    private List<Mascota> mascotasAtendida;



}
