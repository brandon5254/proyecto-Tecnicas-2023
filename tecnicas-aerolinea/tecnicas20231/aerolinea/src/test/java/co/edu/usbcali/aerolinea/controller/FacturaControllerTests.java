package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.controllers.FacturaController;
import co.edu.usbcali.aerolinea.dtos.FacturaDTO;
import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.services.FacturaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class FacturaControllerTests {

    @Mock
    private FacturaServiceImpl facturaService;

    @InjectMocks
    private FacturaController facturaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerFacturas_DebeRetornarListaDeFacturas() {
        // Arrange
        List<FacturaDTO> facturas = new ArrayList<>();
        facturas.add(new FacturaDTO());
        when(facturaService.obtenerFacturas()).thenReturn(facturas);

        // Act
        ResponseEntity<List<FacturaDTO>> response = facturaController.obtenerFacturas();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(facturas, response.getBody());
    }

    @Test
    public void obtenerFactura_DebeRetornarFacturaExistente() throws Exception {
        // Arrange
        int idFactura = 1;
        FacturaDTO factura = new FacturaDTO();
        when(facturaService.obtenerFactura(idFactura)).thenReturn(factura);

        // Act
        ResponseEntity<FacturaDTO> response = facturaController.obtenerFactura(idFactura);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(factura, response.getBody());
    }

   

    @Test
    public void guardarFactura_DebeRetornarFacturaGuardada() throws Exception {
        // Arrange
        FacturaDTO facturaDTO = new FacturaDTO();
        when(facturaService.agregarFactura(any(FacturaDTO.class))).thenReturn(facturaDTO);

        // Act
        ResponseEntity response = facturaController.guardarFactura(facturaDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(facturaDTO, response.getBody());
    }

    @Test
    public void guardarFactura_DebeRetornarBadRequest_EnCasoDeExcepcion() throws Exception {
        // Arrange
        FacturaDTO facturaDTO = new FacturaDTO();
        String errorMessage = "Error al guardar la factura";
        when(facturaService.agregarFactura(any(FacturaDTO.class))).thenThrow(new Exception(errorMessage));

        // Act
        ResponseEntity response = facturaController.guardarFactura(facturaDTO);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, ((MensajeVueloDTO) response.getBody()).getMensaje());
    }

}
