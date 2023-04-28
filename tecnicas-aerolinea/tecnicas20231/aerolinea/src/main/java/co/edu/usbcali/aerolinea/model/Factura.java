package co.edu.usbcali.aerolinea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "factura")
public class Factura {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "fact_id", nullable = false, unique = true)
        private Integer idFactura;
        @ManyToOne
        @JoinColumn(name = "usua_id", referencedColumnName = "usua_id")
        private Usuario usuario;
        @ManyToOne
        @JoinColumn(name = "rese_id", referencedColumnName = "rese_id")
        private Reserva reserva;
        @Column(name = "estado", nullable = false, length = 1)
        private String estado;
    }
