package co.edu.usbcali.aerolinea.controller;



import co.edu.usbcali.aerolinea.controllers.VueloController;
import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.VueloDTO;
import co.edu.usbcali.aerolinea.services.VueloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class VueloControllerTests {
    @Mock
    private VueloService vueloService;

    @InjectMocks
    private VueloController vueloController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerVuelo_DebeRetornarVueloExistente() throws Exception {
        // Arrange
        int idVuelo = 1;
        VueloDTO vueloDTO = new VueloDTO(); // Crea un objeto VueloDTO de ejemplo
        when(vueloService.obtenerVuelo(idVuelo)).thenReturn(vueloDTO);

        // Act
        ResponseEntity<VueloDTO> response = vueloController.obtenerVuelo(idVuelo);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(vueloDTO, response.getBody());
        verify(vueloService, times(1)).obtenerVuelo(idVuelo);
    }



    @Test
    void obtenerVuelos_DebeRetornarListaDeVuelosExistente() {
        // Arrange
        List<VueloDTO> vuelosDTO = new ArrayList<>(); // Crea una lista de objetos VueloDTO de ejemplo
        when(vueloService.obtenerVuelos()).thenReturn(vuelosDTO);

        // Act
        ResponseEntity<List<VueloDTO>> response = vueloController.obtenerVuelos();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(vuelosDTO, response.getBody());
        verify(vueloService, times(1)).obtenerVuelos();
    }

    @Test
    void guardarVuelo_DebeRetornarVueloGuardado() throws Exception {
        // Arrange
        VueloDTO vueloDTO = new VueloDTO(); // Crea un objeto VueloDTO de ejemplo
        when(vueloService.guardarVuelo(vueloDTO)).thenReturn(vueloDTO);

        // Act
        ResponseEntity response = vueloController.guardarVuelo(vueloDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(vueloDTO, response.getBody());
        verify(vueloService, times(1)).guardarVuelo(vueloDTO);
    }

   
}
