package co.edu.usbcali.aerolinea.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class AvionDTO {
    private Integer idAvion;
    private String modelo;
    private String estado;
}
