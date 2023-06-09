package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.controllers.TipoAsientoController;
import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.TipoAsientoDTO;
import co.edu.usbcali.aerolinea.services.TipoAsientoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import co.edu.usbcali.aerolinea.dtos.TipoAsientoDTO;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TipoAsientoControllerTests {


    @Mock
    private TipoAsientoServiceImpl tipoAsientoService;

    @InjectMocks
    private TipoAsientoController tipoAsientoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerTipoAsientos_DebeRetornarListaDeTipoAsientos() {
        // Preparación
        List<TipoAsientoDTO> tipoAsientos = new ArrayList<>();
        tipoAsientos.add(new TipoAsientoDTO("Asiento1"));
        tipoAsientos.add(new TipoAsientoDTO("Asiento2"));

        when(tipoAsientoService.obtenerTipoAsientos()).thenReturn(tipoAsientos);

        // Ejecución
        ResponseEntity<List<TipoAsientoDTO>> response = tipoAsientoController.obtenerTipoAsientos();

        // Verificación
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }





    @Test
    public void guardarTipoAsiento_DebeRetornarTipoAsientoCreado() throws Exception {
        // Preparación
        TipoAsientoDTO tipoAsientoDTO = new TipoAsientoDTO("Asiento1");

        when(tipoAsientoService.agregarTipoAsiento(tipoAsientoDTO)).thenReturn(tipoAsientoDTO);

        // Ejecución
        ResponseEntity response = tipoAsientoController.guardarTipoAsiento(tipoAsientoDTO);

        // Verificación
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Asiento1", ((TipoAsientoDTO) response.getBody()).getNombre());
    }

    @Test
    public void guardarTipoAsiento_DebeRetornarBadRequestCuandoExcepcionEsLanzada() throws Exception {
        // Preparación
        TipoAsientoDTO tipoAsientoDTO = new TipoAsientoDTO("Asiento1");

        when(tipoAsientoService.agregarTipoAsiento(tipoAsientoDTO)).thenThrow(new RuntimeException("Error al guardar tipo de asiento"));

        // Ejecución
        ResponseEntity response = tipoAsientoController.guardarTipoAsiento(tipoAsientoDTO);

        // Verificación
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Error al guardar tipo de asiento", ((MensajeVueloDTO) response.getBody()).getMensaje());
    }
}
