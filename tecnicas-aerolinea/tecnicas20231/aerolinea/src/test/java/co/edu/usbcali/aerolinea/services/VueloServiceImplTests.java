package co.edu.usbcali.aerolinea.services;



import co.edu.usbcali.aerolinea.model.Avion;
import co.edu.usbcali.aerolinea.model.Vuelo;
import co.edu.usbcali.aerolinea.dtos.VueloDTO;
import co.edu.usbcali.aerolinea.repository.AvionRepository;
import co.edu.usbcali.aerolinea.repository.VueloRepository;
import co.edu.usbcali.aerolinea.services.VueloServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class VueloServiceImplTests {
    @InjectMocks
    private VueloServiceImpl vueloService;
    @Mock
    private VueloRepository vueloRepository;
    @Mock
    private AvionRepository avionRepository;
    @Mock
    private ModelMapper modelMapper;


    @Test
    public void obtenerVueloTest()throws Exception{
        Avion avion = Avion.builder()
                .idAvion(3)
                .modelo("BOEING777")
                .estado("A")
                .build();
        Vuelo vuelo = Vuelo.builder()
                .idVuelo(4)
                .precio(500000)
                .precioAsientoNormal(120000)
                .precioAsientoBasico(150000)
                .precioAsientoVip(200000)
                .fechaHoraSalida(new Date("12/08/2023"))
                .fechaHoraLlegada(new Date("14/08/2023"))
                .origen("cali")
                .destino("peru")
                .estado("A")
                .avion(avion)
                .build();

        given(vueloRepository.findById(3)).willReturn(Optional.of(vuelo));

        VueloDTO vueloConsultado = vueloService.obtenerVuelo(3);

        assertEquals(vueloConsultado.getIdVuelo(), vuelo.getIdVuelo());
    }
    @Test
    public void obtenerVuelosTest(){
        Avion avion = Avion.builder()
                .idAvion(3)
                .modelo("BOEING777")
                .estado("A")
                .build();
        Vuelo vuelosRetorno = Vuelo.builder()
                .idVuelo(4)
                .precio(500000)
                .precioAsientoNormal(120000)
                .precioAsientoBasico(150000)
                .precioAsientoVip(200000)
                .fechaHoraSalida(new Date("12/08/2023"))
                .fechaHoraLlegada(new Date("14/08/2023"))
                .origen("cali")
                .destino("peru")
                .estado("A")
                .avion(avion)
                .build();

        Mockito.when(vueloRepository.findAll()).thenReturn(Arrays.asList(vuelosRetorno));

        List<VueloDTO> vuelos = vueloService.obtenerVuelos();

        assertEquals(1, vuelos.size());
    }
}
