package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.RolUsuarioDTO;
import co.edu.usbcali.aerolinea.mapper.RolUsuarioMapper;
import co.edu.usbcali.aerolinea.model.RolUsuario;
import co.edu.usbcali.aerolinea.repository.RolUsuarioRepository;
import co.edu.usbcali.aerolinea.services.RolUsuarioService;
import org.springframework.stereotype.Service;

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
