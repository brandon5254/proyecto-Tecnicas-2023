package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.RolUsuarioDTO;
import co.edu.usbcali.aerolinea.mapper.RolUsuarioMapper;
import co.edu.usbcali.aerolinea.model.RolUsuario;
import co.edu.usbcali.aerolinea.repository.RolUsuarioRepository;
import co.edu.usbcali.aerolinea.services.RolUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RolUsuarioServiceImpl implements RolUsuarioService {

    private final RolUsuarioRepository rolUsuarioRepository;

    public RolUsuarioServiceImpl(RolUsuarioRepository rolUsuarioRepository) {
        this.rolUsuarioRepository = rolUsuarioRepository;
    }


    @Override
    public List<RolUsuarioDTO> buscartodos(){
        List<RolUsuario> rolUsuarios =
        rolUsuarioRepository.findAll();
        return RolUsuarioMapper.modelToDtoList(rolUsuarios);

    }


    @Override
    public RolUsuarioDTO obtenerRolUsuario(Integer id) throws Exception {
        if (rolUsuarioRepository.findById(id).isEmpty()){
            throw new Exception("El id"+ id + "no corresponde a ningun usuario!");
        }
        return RolUsuarioMapper.modelDto(rolUsuarioRepository.findById(id).get());
    }

    @Override
    public RolUsuarioDTO guardarNuevoRollUsuario(RolUsuarioDTO rolUsuarioDTO) throws Exception {
        //Validar DTO
        if (rolUsuarioDTO == null) {
            throw new Exception("El rol usuario puede ser nulo");
        }
        if (rolUsuarioDTO.getRousId() == null ||
                rolUsuarioDTO.getRousId().equals(0)) {
            throw new Exception("Id no puede ser nulo o 0");
        }
        if (rolUsuarioDTO.getDescripcion() == null ||
                rolUsuarioDTO.getDescripcion().trim().isEmpty()) {
            throw new Exception("Descripcion no puede ser nulo o 0");
        }
        if (rolUsuarioDTO.getEstado() == null ||
                rolUsuarioDTO.getEstado().trim().isEmpty()) {
            throw new Exception("Estado no puede ser nulo o 0");
        }
        //Convertir DTO a Modelo
        RolUsuario rolUsuario = RolUsuarioMapper.dtoToModel((rolUsuarioDTO));
        return RolUsuarioMapper.modelDto(rolUsuarioRepository.save(rolUsuario));
    }


}
