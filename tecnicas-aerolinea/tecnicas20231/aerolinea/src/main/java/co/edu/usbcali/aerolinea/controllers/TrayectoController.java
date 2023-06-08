package co.edu.usbcali.aerolinea.controllers;

import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.TrayectoDTO;
import co.edu.usbcali.aerolinea.services.TrayectoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trayecto")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })

public class TrayectoController {
    private final TrayectoService trayectoService;
    public TrayectoController(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }
    @GetMapping("/obtenerTrayecto/{idTrayecto}")
    public ResponseEntity<TrayectoDTO> obtenerTrayecto(@PathVariable("idTrayecto") Integer idTrayecto) {
        try {
            return new ResponseEntity(trayectoService.obtenerTrayecto(idTrayecto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeVueloDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(path = "/agregarTrayecto",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarTrayecto(@RequestBody TrayectoDTO trayectoDTO) {
        try {
            return new ResponseEntity(trayectoService.agregarTrayecto(trayectoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeVueloDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/obtenerTrayectos")
    public ResponseEntity<List<TrayectoDTO>> obtenerTrayectos() {
        return new ResponseEntity(trayectoService.obtenerTrayectos(), HttpStatus.OK);
    }
}
