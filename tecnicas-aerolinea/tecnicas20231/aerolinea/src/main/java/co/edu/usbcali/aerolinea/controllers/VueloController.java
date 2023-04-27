package co.edu.usbcali.aerolinea.controllers;

import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.VueloDTO;
import co.edu.usbcali.aerolinea.services.VueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelo")
public class VueloController {



        private VueloService vueloService;
        public VueloController(VueloService vueloService) {
            this.vueloService = vueloService;
        }
        @GetMapping("/obtenerVuelo/{idVuelo}")
        public ResponseEntity<VueloDTO> obtenerVuelo(@PathVariable("idVuelo") Integer idVuelo){
            try {
                return new ResponseEntity(vueloService.obtenerVuelo(idVuelo), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity(MensajeVueloDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
            }
        }
        @GetMapping("/obtenerVuelos")
        public ResponseEntity<List<VueloDTO>> obtenerVuelos() {
            return new ResponseEntity(vueloService.obtenerVuelos(), HttpStatus.OK);
        }
        @PostMapping(path = "/guardarVuelo",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity guardarVuelo(@RequestBody VueloDTO vuelDTO) {
            try {
                return new ResponseEntity(vueloService.guardarVuelo(vuelDTO), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity(MensajeVueloDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
            }

        }
    }