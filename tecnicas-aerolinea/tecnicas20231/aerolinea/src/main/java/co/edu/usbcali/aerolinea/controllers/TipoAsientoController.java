package co.edu.usbcali.aerolinea.controllers;

import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.TipoAsientoDTO;
import co.edu.usbcali.aerolinea.services.TipoAsientoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoasiento")
@Slf4j
public class TipoAsientoController {
    private final TipoAsientoServiceImpl tipoAsientoService;

    public TipoAsientoController(TipoAsientoServiceImpl tipoAsientoService) {
        this.tipoAsientoService = tipoAsientoService;
    }

    @GetMapping("/obtenerTipoAsientos")
    public ResponseEntity<List<TipoAsientoDTO>> obtenerTipoAsientos() {
        return new ResponseEntity(tipoAsientoService.obtenerTipoAsientos(), HttpStatus.OK);
    }
    @PostMapping(path = "/agregarTipoAsiento",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarTipoAsiento(@RequestBody TipoAsientoDTO tipoAsientoDTO) {
        try {
            return new ResponseEntity(tipoAsientoService.agregarTipoAsiento(tipoAsientoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeVueloDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerTipoAsiento")
    public ResponseEntity<TipoAsientoDTO> obtenerTipoAsiento(@PathVariable("idTipoa") Integer idTipoa) {
        try {
            return new ResponseEntity(tipoAsientoService.obtenerTipoAsiento(idTipoa), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeVueloDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

}
