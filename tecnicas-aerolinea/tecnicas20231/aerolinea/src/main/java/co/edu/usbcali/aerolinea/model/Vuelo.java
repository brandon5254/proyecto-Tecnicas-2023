package co.edu.usbcali.aerolinea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vuelo")
public class Vuelo {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vuel_id", nullable = false, unique = true)
    private Integer idVuelo;
    /*@ManyToOne
    @JoinColumn(name = "origen", referencedColumnName = "aero_id")
    private Aeropuerto idAeropuertoOrigen;
    @ManyToOne
    @JoinColumn(name = "destino", referencedColumnName = "aero_id")
    private Aeropuerto idAeropuertoDestino;*/

    @OneToOne
    @JoinColumn(name = "avio_id", referencedColumnName = "avio_id")
    private Avion avion;
    private String origen;
    private String destino;
    @Column(name = "precio", nullable = false)
    private long precio;
    @Column(name = "hora_salida", nullable = false)
    @CreationTimestamp
    private java.util.Date fechaHoraSalida;
    @Column(name = "hora_llegada", nullable = false)
    @CreationTimestamp
    private Date fechaHoraLlegada;
    @Column(name = "precio_asiento_basico", nullable = false)
    private long precioAsientoBasico;
    @Column(name = "precio_asiento_vip", nullable = false)
    private long precioAsientoVip;
    @Column(name = "precio_asiento_normal", nullable = false)
    private long precioAsientoNormal;
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
}