package com.stefanini.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.stefanini.domain.OrdenPago;
import com.stefanini.domain.Sucursal;
import com.stefanini.repository.OrdenPagoRepository;
import com.stefanini.repository.SucursalRepository;
import com.stefanini.rest.dto.OrdenPagoDTO;
import com.stefanini.service.OrdenPagoService;

@Service
public class OrdenPagoServiceImpl implements OrdenPagoService {

	@Inject
	private OrdenPagoRepository ordenPagoRepository;

	@Inject
	private SucursalRepository sucursalRepository;

	@Override
	public OrdenPago create(OrdenPagoDTO ordenPagoDTO) {
		Optional<Sucursal> sucursalOp = sucursalRepository.findById(ordenPagoDTO.getIdSucursal());

		if (sucursalOp.isPresent()) {
			OrdenPago ordenPago = OrdenPago.builder()
					.sucursal(sucursalOp.get())
					.monto(ordenPagoDTO.getMonto())
					.moneda(ordenPagoDTO.getMoneda())
					.estado(ordenPagoDTO.getEstado())
					.fechaPago(ordenPagoDTO.getFechaPago())
					.build();

			return ordenPagoRepository.saveAndFlush(ordenPago);
		}

		return null;
	}

	@Override
	public OrdenPago update(OrdenPagoDTO ordenPagoDTO) {
		Optional<OrdenPago> ordenPagoOp = ordenPagoRepository.findById(ordenPagoDTO.getIdOrdenpago());

		if (ordenPagoOp.isPresent()) {
			OrdenPago ordenPago = ordenPagoOp.get();

			ordenPago.setMonto(ordenPagoDTO.getMonto());
			ordenPago.setMoneda(ordenPagoDTO.getMoneda());
			ordenPago.setEstado(ordenPagoDTO.getEstado());
			ordenPago.setFechaPago(ordenPagoDTO.getFechaPago());
			
			return ordenPagoRepository.saveAndFlush(ordenPago);
		}

		return null;
	}

	@Override
	public boolean deleteById(Long idOrdenPago) {
		boolean flag = true;

		try {
			ordenPagoRepository.deleteById(idOrdenPago);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	public List<OrdenPago> getOrdenesPago() {
		return ordenPagoRepository.findAll();
	}

	@Override
	public List<OrdenPago> getOrdenesByFiltros(Long idSucursal, String moneda) {
		return ordenPagoRepository.findAllBySucursalIdSucursalAndMoneda(idSucursal, moneda);
	}

}
