package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.model.Avion;
import co.edu.usbcali.aerolinea.dtos.AeropuertoDTO;
import co.edu.usbcali.aerolinea.dtos.AvionDTO;
import co.edu.usbcali.aerolinea.repository.AvionRepository;
import co.edu.usbcali.aerolinea.services.AvionServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class AvionServiceImplTests {
    @InjectMocks
    AvionServiceImpl avionService;
    @Mock
    private AvionRepository avionRepository;

    @Test
    public void obtenerAvionesTest(){
        List<Avion> avionesRetorno = Arrays.asList(Avion.builder()
                .idAvion(2)
                .estado("A")
                .modelo("latam")
                .build(), Avion.builder()
                .idAvion(3)
                .estado("B")
                .modelo("avianca")
                .build());

        Mockito.when(avionRepository.findAll()).thenReturn(avionesRetorno);

        List<AvionDTO> aviones = avionService.obtenerAviones();

        assertEquals(2, aviones.size());
    }
    @Test
    public void obtenerAvionTest() throws Exception{
        Avion avion = Avion.builder()
                .idAvion(2)
                .modelo("latam")
                .estado("A")
                .build();

        given(avionRepository.findById(2)).willReturn(Optional.of(avion));

        AvionDTO avionConsultado = avionService.obtenerAvion(2);

        assertEquals(avionConsultado.getEstado(), avion.getEstado());
    }
}
