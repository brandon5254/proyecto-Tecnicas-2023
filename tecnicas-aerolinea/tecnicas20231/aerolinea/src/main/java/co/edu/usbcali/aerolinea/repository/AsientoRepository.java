package co.edu.usbcali.aerolinea.repository;

import co.edu.usbcali.aerolinea.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Integer> {
}