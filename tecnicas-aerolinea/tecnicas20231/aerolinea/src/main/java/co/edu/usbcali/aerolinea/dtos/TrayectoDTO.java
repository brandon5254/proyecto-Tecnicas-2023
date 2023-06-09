package co.edu.usbcali.aerolinea.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class TrayectoDTO {
    private Integer idTrayecto;
    private Integer idAeropuertoDestino;
    private Integer idAeropuertoOrigen;
    private Integer idVuelo;
    private String estado;

    public TrayectoDTO() {

    }

    public String getMensaje() {
        return null;
    }
}
