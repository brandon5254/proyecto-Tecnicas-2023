package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.model.Reserva;
import co.edu.usbcali.aerolinea.dtos.ReservaDTO;
import co.edu.usbcali.aerolinea.mapper.ReservaMapper;
import co.edu.usbcali.aerolinea.model.Vuelo;
import co.edu.usbcali.aerolinea.repository.ReservaRepository;
import co.edu.usbcali.aerolinea.services.ReservaService;

import co.edu.usbcali.aerolinea.repository.AsientoRepository;
import co.edu.usbcali.aerolinea.repository.TipoAsientoRepository;
import co.edu.usbcali.aerolinea.repository.VueloRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final ModelMapper modelMapper;
    public ReservaServiceImpl(ReservaRepository reservaRepository, ModelMapper modelMapper) {
        this.reservaRepository = reservaRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<ReservaDTO> obtenerReservas() {
        return ReservaMapper.modelToDTOList(reservaRepository.findAll());
    }
    @Override
    public ReservaDTO obtenerReserva(Integer id) throws Exception {
        if (reservaRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ninguna reserva!");
        }
        return ReservaMapper.modelToDTO(reservaRepository.findById(id).get());
    }
    @Override
    public ReservaDTO agregarReserva(ReservaDTO reservaDTO) throws Exception {
        if (reservaDTO == null) {
            throw new Exception("La reserva es invalida!");
        }
        if (reservaDTO.getPrecioTotal() < 0) {
            throw new Exception("El precio de la reserva no puede ser negativo!");
        }
        if (reservaDTO.getEstadoPago() == null || reservaDTO.getEstadoPago().isBlank() || reservaDTO.getEstadoPago().trim().isEmpty()) {
            throw new Exception("El estado de pago de la reserva es invalido!");
        }
        if (reservaDTO.getEstado() == null || reservaDTO.getEstado().isBlank() || reservaDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado de la reserva es invalido!");
        }
        if(reservaRepository.findById(reservaDTO.getIdReserva()).isPresent()){
            throw new Exception("Ya existe el id de la reserva!");
        }
        Reserva reserva = ReservaMapper.dtoToModel(reservaDTO);



        Reserva saved = reservaRepository.save(reserva);
        return ReservaMapper.modelToDTO(reservaRepository.save(reserva));
    }
}
