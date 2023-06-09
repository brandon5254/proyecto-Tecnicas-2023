package co.edu.usbcali.aerolinea.dtos;

import co.edu.usbcali.aerolinea.model.Avion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@ToString
public class VueloDTO {
    private Integer idVuelo;
    private String origen;
    private String destino;
    private long precio;
    private Date fechaHoraSalida;
    private Date fechaHoraLlegada;
    private long precioAsientoBasico;
    private long precioAsientoVip;
    private long precioAsientoNormal;
    private String estado;
    private Avion avion;

    public VueloDTO() {

    }
}
