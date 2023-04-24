package co.edu.usbcali.aerolinea.services;



import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

        import java.util.ArrayList;
        import java.util.List;

import co.edu.usbcali.aerolinea.dtos.VueloDTO;
import co.edu.usbcali.aerolinea.model.Vuelo;
import co.edu.usbcali.aerolinea.repository.VueloRepository;
import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;

public class VueloServiceImplTests {


    @InjectMocks
    private VueloServiceImplTests vueloServiceImplTests;

    @Mock
    private VueloRepository vueloRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public List<VueloDTO> testObtenerVuelos() {
        // Datos de prueba
        List<Vuelo> vuelos = new ArrayList<>(); // reemplaza con el tipo de objeto que retorna vueloRepository.findAll()
        vuelos.add(new Vuelo()); // agrega vuelos de ejemplo a la lista
        vuelos.add(new Vuelo());

        // Mock del comportamiento de vueloRepository.findAll()
        when(vueloRepository.findAll()).thenReturn(vuelos);

        // Llamada al método bajo prueba
        List<VueloDTO> resultado = vueloServiceImplTests.testObtenerVuelos();

        // Verificación de resultados
        assertNotNull(resultado);
        assertEquals(vuelos.size(), resultado.size());
        // Puedes agregar más aserciones para verificar el mapeo de Vuelo a VueloDTO si es necesario
        return resultado;
    }
}
