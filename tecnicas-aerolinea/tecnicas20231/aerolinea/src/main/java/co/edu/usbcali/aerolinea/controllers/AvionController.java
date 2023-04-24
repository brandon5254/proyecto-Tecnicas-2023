package co.edu.usbcali.aerolinea.controllers;



import co.edu.usbcali.aerolinea.dtos.AvionDTO;
import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.services.AvionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avion")
@Slf4j
public class AvionController {

    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @GetMapping("/obtenerAviones")
    public ResponseEntity<List<AvionDTO>> obtenerAviones(){
        log.info("AvionController: Ha ingresado a buscar todos los aviones");
        return new ResponseEntity(avionService.obtenerAviones(), HttpStatus.OK);
    }

    @GetMapping("/obtenerAvion/{idAvion}")
    public ResponseEntity<AvionDTO> obtenerAvion(@PathVariable("idAvion") Integer idAvion) {
        try {
            return new ResponseEntity(avionService.obtenerAvion(idAvion), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeVueloDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }



    @PostMapping(path = "/guardarAvion",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarAvion(@RequestBody AvionDTO avionDTO) {
        try {
            return new ResponseEntity(avionService.guardarNuevoAvion(avionDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeVueloDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}