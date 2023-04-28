package co.edu.usbcali.aerolinea.services;


import co.edu.usbcali.aerolinea.dtos.TrayectoDTO;
import co.edu.usbcali.aerolinea.model.Aeropuerto;
import co.edu.usbcali.aerolinea.model.Avion;
import co.edu.usbcali.aerolinea.model.Trayecto;
import co.edu.usbcali.aerolinea.model.Vuelo;
import co.edu.usbcali.aerolinea.repository.AeropuertoRepository;
import co.edu.usbcali.aerolinea.repository.TrayectoRepository;
import co.edu.usbcali.aerolinea.repository.VueloRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class TrayectoServiceImplTests {
    @InjectMocks
    private TrayectoServiceImpl trayectoService;
    @Mock
    private TrayectoRepository trayectoRepository;
    @Mock
    private AeropuertoRepository aeropuertoRepository;
    @Mock
    private VueloRepository vueloRepository;


    @Test

    public void obtenerTrayectoTest() throws Exception{
        Aeropuerto aeropuerto = Aeropuerto.builder()
                .aero_id(2)
                .nombre("Santa Monica")
                .estado("A")
                .iata("SM")
                .ubicacion("Barranquilla")
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
                .avion(Avion.builder()
                        .idAvion(3)
                        .modelo("BOEING777")
                        .estado("A")
                        .build())
                .build();
        Trayecto trayecto = Trayecto.builder()
                .idTrayecto(2)
                .idAeropuertoOrigen(aeropuerto)
                .idAeropuertoDestino(aeropuerto)
                .idVuelo(vuelo)
                .estado("A")
                .build();

        given(trayectoRepository.findById(3)).willReturn(Optional.of(trayecto));

        TrayectoDTO trayectoConsultado = trayectoService.obtenerTrayecto(3);

        assertEquals(trayectoConsultado.getIdTrayecto(), trayecto.getIdTrayecto());

    }
    @Test

    public void obtenerTrayectosTest(){
        Aeropuerto aeropuerto = Aeropuerto.builder()
                .aero_id(2)
                .nombre("Santa Monica")
                .estado("A")
                .iata("SM")
                .ubicacion("Barranquilla")
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
                .avion(Avion.builder()
                        .idAvion(3)
                        .modelo("BOEING777")
                        .estado("A")
                        .build())
                .build();
        Trayecto trayectosRetorno = Trayecto.builder()
                .idTrayecto(2)
                .idAeropuertoOrigen(aeropuerto)
                .idAeropuertoDestino(aeropuerto)
                .idVuelo(vuelo)
                .estado("A")
                .build();

        Mockito.when(trayectoRepository.findAll()).thenReturn(Arrays.asList(trayectosRetorno));

        List<TrayectoDTO> trayectos = trayectoService.obtenerTrayectos();

        assertEquals(1, trayectos.size());

    }

}