package co.edu.usbcali.aerolinea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "rol_usuario")
public class RolUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rous_id", nullable = false)
    private Integer rousId;
    @Column(nullable = false, length = 30)
    private String descripcion;
    @Column(nullable = false, length = 1)
    private String estado;

    public RolUsuario(String admin, String admin1) {
    }
}