package co.edu.usbcali.aerolinea.controller;




        import co.edu.usbcali.aerolinea.controllers.AeropuertoController;
        import co.edu.usbcali.aerolinea.dtos.AeropuertoDTO;
        import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
        import co.edu.usbcali.aerolinea.services.AeropuertoService;
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
        import static org.mockito.Mockito.*;
public class AeropuertoControllerTests {


    @Mock
    private AeropuertoService aeropuertoService;

    @InjectMocks
    private AeropuertoController aeropuertoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
        //nota :Esta prueba verifica si el método obtenerAeropuerto retorna
        //un aeropuerto existente correctamente.
    void obtenerAeropuerto_DebeRetornarAeropuertoExistente() throws Exception {
        // Arrange
        Integer idAeropuerto = 1;
        AeropuertoDTO aeropuertoDTO = new AeropuertoDTO();
        aeropuertoDTO.setAero_id(idAeropuerto);
        when(aeropuertoService.obtenerAeropuerto(idAeropuerto)).thenReturn(aeropuertoDTO);

        // Act
        ResponseEntity<AeropuertoDTO> response = aeropuertoController.obtenerAeropuerto(idAeropuerto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(aeropuertoDTO, response.getBody());
        verify(aeropuertoService, times(1)).obtenerAeropuerto(idAeropuerto);
    }

    @Test


        //nota: Esta prueba verifica si el método obtenerAeropuertos
        // retorna una lista de aeropuertos correctamente.
    void obtenerAeropuertos_DebeRetornarListaAeropuertos() throws Exception {
        // Arrange
        List<AeropuertoDTO> aeropuertoDTOList = new ArrayList<>();
        when(aeropuertoService.obtenerAeropuertos()).thenReturn(aeropuertoDTOList);

        // Act
        ResponseEntity<List<AeropuertoDTO>> response = aeropuertoController.obtenerAeropuertos();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(aeropuertoDTOList, response.getBody());
        verify(aeropuertoService, times(1)).obtenerAeropuertos();
    }

    @Test
    //nota Esta prueba verifica si el método agregarAeropuerto agrega un
        // aeropuerto existente correctamente
    void agregarAeropuerto_DebeAgregarAeropuertoExistente() throws Exception {
        // Arrange
        AeropuertoDTO aeropuertoDTO = new AeropuertoDTO();
        when(aeropuertoService.agregarAeropuerto(aeropuertoDTO)).thenReturn(aeropuertoDTO);

        // Act
        ResponseEntity response = aeropuertoController.agregarAeropuerto(aeropuertoDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(aeropuertoDTO, response.getBody());
        verify(aeropuertoService, times(1)).agregarAeropuerto(aeropuertoDTO);
    }
}

