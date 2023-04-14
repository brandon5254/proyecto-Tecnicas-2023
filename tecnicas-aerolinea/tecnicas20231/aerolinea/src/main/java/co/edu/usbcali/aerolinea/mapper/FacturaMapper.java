package co.edu.usbcali.aerolinea.mapper;


import co.edu.usbcali.aerolinea.model.Factura;
import co.edu.usbcali.aerolinea.dtos.FacturaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FacturaMapper {
    public static FacturaDTO modelToDTO(Factura factura) {
        return FacturaDTO.builder()
                .idFactura(factura.getIdFactura())

                .fecha(factura.getFecha())
                .estado(factura.getEstado())
                .build();
    }

    public static List<FacturaDTO> modelToDTOList(List<Factura> facturas) {
        return facturas.stream().map(factura -> modelToDTO(factura)).collect(Collectors.toList());
    }

    public static Factura dtoToModel(FacturaDTO facturaDTO) {
        return Factura.builder()
                .idFactura(facturaDTO.getIdFactura())
                .fecha(facturaDTO.getFecha())
                .estado(facturaDTO.getEstado())
                .build();
    }

    public static List<Factura> dtoToModelList(List<FacturaDTO> facturasDTO) {
        return facturasDTO.stream().map(facturaDTO -> dtoToModel(facturaDTO)).collect(Collectors.toList());
    }
}