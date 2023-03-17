package co.edu.usbcali.aerolinea.controllers;



import co.edu.usbcali.aerolinea.model.RolUsuario;
import co.edu.usbcali.aerolinea.services.RolUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
