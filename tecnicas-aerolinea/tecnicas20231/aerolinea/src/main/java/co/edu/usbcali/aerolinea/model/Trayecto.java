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
@Table(name = "trayecto")
public class Trayecto {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tray_id", nullable = false, unique = true)
    private Integer idTrayecto;
    @ManyToOne
    @JoinColumn(name = "aero_id_desti", referencedColumnName = "aero_id_desti")
    private Aeropuerto idAeropuertoDestino;
    @ManyToOne
    @JoinColumn(name = "aero_id_origen", referencedColumnName = "aero_id_origen")
    private Aeropuerto idAeropuertoOrigen;
    @ManyToOne
    @JoinColumn(name = "vuel_id", referencedColumnName = "vuel_id")
    private Vuelo idVuelo;
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
}