package co.edu.usbcali.aerolinea.controllers;



import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.RolUsuarioDTO;
import co.edu.usbcali.aerolinea.model.RolUsuario;
import co.edu.usbcali.aerolinea.services.RolUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;




    @RestController
    @RequestMapping("/rolusuario")
    public class RolUsuarioController {
        private  final RolUsuarioService rolUsuarioService;

        public RolUsuarioController(RolUsuarioService rolUsuarioService) {
            this.rolUsuarioService = rolUsuarioService;
        }

        @GetMapping("/todos")
        public ResponseEntity<List<RolUsuario>> todos(){
            return  new ResponseEntity(
                    rolUsuarioService.buscartodos()
                    , HttpStatus.OK);
        }

        ///aqui va el postmapping



        @PostMapping(path = "/guardarNuevoRolUsuario",
          consumes= MediaType.APPLICATION_JSON_VALUE,
          produces= MediaType.APPLICATION_JSON_VALUE)
        public  ResponseEntity guardarNuevoRolUsuario(@RequestBody RolUsuarioDTO rolUsuarioDTO){
            try{
                return new ResponseEntity(rolUsuarioService.guardarNuevoRollUsuario(rolUsuarioDTO),HttpStatus.OK);


            }catch (Exception e){

                return  new ResponseEntity(MensajeVueloDTO.builder().mensaje(e.getMessage()).build(),HttpStatus.BAD_REQUEST);
            }
        }
}
