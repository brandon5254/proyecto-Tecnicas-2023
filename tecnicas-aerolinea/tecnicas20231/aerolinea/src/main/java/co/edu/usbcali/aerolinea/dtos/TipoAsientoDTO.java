package co.edu.usbcali.aerolinea.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class TipoAsientoDTO {
    private Integer idTipoAsiento;
    private String descripcion;
    private String estado;

    public TipoAsientoDTO() {

    }
       private String nombre;

        public TipoAsientoDTO(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }

