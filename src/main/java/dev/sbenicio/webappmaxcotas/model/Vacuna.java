package dev.sbenicio.webappmaxcotas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data   //toString, equals, hashcode, getters y setters
@NoArgsConstructor
@AllArgsConstructor
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "El nombre NO puede estar en blanco")
    private String nombre;

    @NotNull(message = "La Fecha de Vencimiento no puede estar en blanco")
    private LocalDate fechaVencimiento;

    @ManyToMany(mappedBy = "vacunasAplicadas",fetch = FetchType.EAGER)
    private List<Mascota> mascotas = new ArrayList<>();

}
