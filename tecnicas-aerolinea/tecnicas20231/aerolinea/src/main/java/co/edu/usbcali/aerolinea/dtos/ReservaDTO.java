package co.edu.usbcali.aerolinea.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class ReservaDTO {
    private Integer idReserva;
    private Integer idVuelo;
    private long precioTotal;
    private String estadoPago;
    private String estado;

    public ReservaDTO(int idReserva, String s) {
    }

    public ReservaDTO() {

    }
}
