package co.edu.usbcali.aerolinea.services;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import co.edu.usbcali.aerolinea.dtos.AeropuertoDTO;
import co.edu.usbcali.aerolinea.model.Aeropuerto;
import co.edu.usbcali.aerolinea.repository.AeropuertoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


    @SpringBootTest
    public class AeropuertoServiceImplTest {

        @InjectMocks
        private AeropuertoServiceImpl aeropuertoService;
        @Mock
        private AeropuertoRepository aeropuertoRepository;


        @Test
        public void obtenerAeropuertosTest() {
            List<Aeropuerto> aeropuertosRetorno = Arrays.asList(Aeropuerto.builder()
                    .nombre("Alfonso Bonilla")
                    .iata("COL")
                    .aero_id(3)
                    .ubicacion("Cali")
                    .estado("A")
                    .build(), Aeropuerto.builder()
                    .nombre("Alfonso Bonilla")
                    .iata("COL")
                    .aero_id(3)
                    .ubicacion("Cali")
                    .estado("A")
                    .build());

            Mockito.when(aeropuertoRepository.findAll()).thenReturn(aeropuertosRetorno);

            List<AeropuertoDTO> aeropuertos = aeropuertoService.obtenerAeropuertos();

            assertEquals(2, aeropuertos.size());
        }
        @Test
        public void obtenerAeropuertoTest() throws Exception{
            Aeropuerto aeropuerto = Aeropuerto.builder()
                    .nombre("Aeropuerto Vanguardia")
                    .iata("VVC")
                    .aero_id(4)
                    .ubicacion("Villavicencio")
                    .estado("A")
                    .build();

            given(aeropuertoRepository.findById(4)).willReturn(Optional.of(aeropuerto));

            AeropuertoDTO aeropuertoConsultado = aeropuertoService.obtenerAeropuerto(4);

            assertEquals(aeropuertoConsultado.getUbicacion(), aeropuerto.getUbicacion());
        }


    }
