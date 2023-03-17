package co.edu.usbcali.aerolinea.repository;


import co.edu.usbcali.aerolinea.model.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Integer> {
}