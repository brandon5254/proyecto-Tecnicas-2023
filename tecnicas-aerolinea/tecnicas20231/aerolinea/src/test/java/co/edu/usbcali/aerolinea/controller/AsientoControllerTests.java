package co.edu.usbcali.aerolinea.controller;



import co.edu.usbcali.aerolinea.controllers.AsientoController;
        import co.edu.usbcali.aerolinea.dtos.AsientoDTO;
        import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
        import co.edu.usbcali.aerolinea.services.AsientoService;
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

public class AsientoControllerTests {

    @Mock
    private AsientoService asientoService;

    @InjectMocks
    private AsientoController asientoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerAsientos_DebeRetornarListaDeAsientos() {
        // Arrange
        List<AsientoDTO> asientos = new ArrayList<>();
        // Agrega asientos de prueba a la lista asientos...

        when(asientoService.obtenerAsientos()).thenReturn(asientos);

        // Act
        ResponseEntity<List<AsientoDTO>> response = asientoController.obtenerAsientos();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(asientos, response.getBody());
        verify(asientoService, times(1)).obtenerAsientos();
    }

    @Test
    public void obtenerAsiento_ConIdExistente_DebeRetornarAsiento() throws Exception {
        // Arrange
        Integer idAsiento = 1;
        AsientoDTO asientoDTO = new AsientoDTO();
        // Configura asientoDTO con los datos de prueba...

        when(asientoService.obtenerAsiento(idAsiento)).thenReturn(asientoDTO);

        // Act
        ResponseEntity<AsientoDTO> response = asientoController.obtenerAsiento(idAsiento);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(asientoDTO, response.getBody());
        verify(asientoService, times(1)).obtenerAsiento(idAsiento);
    }



    @Test
    public void guardarAsiento_ConAsientoValido_DebeRetornarOk() throws Exception {
        // Arrange
        AsientoDTO asientoDTO = new AsientoDTO();
        // Configura asientoDTO con los datos de prueba...

        when(asientoService.agregarAsiento(asientoDTO)).thenReturn(asientoDTO);

        // Act
        ResponseEntity response = asientoController.guardarAsiento(asientoDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(asientoDTO, response.getBody());
        verify(asientoService, times(1)).agregarAsiento(asientoDTO);
    }

    @Test
    public void guardarAsiento_ConAsientoInvalido_DebeRetornarBadRequest() throws Exception {
        // Arrange
        AsientoDTO asientoDTO = new AsientoDTO();
        // Configura asientoDTO con datos inválidos...

        String errorMessage = "El asiento es inválido";
        when(asientoService.agregarAsiento(asientoDTO)).thenThrow(new Exception(errorMessage));

        // Act
        ResponseEntity response = asientoController.guardarAsiento(asientoDTO);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, ((MensajeVueloDTO) response.getBody()).getMensaje());

        verify(asientoService, times(1)).agregarAsiento(asientoDTO);
    }
}

