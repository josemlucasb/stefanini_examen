package com.stefanini.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.stefanini.domain.Banco;
import com.stefanini.domain.Sucursal;
import com.stefanini.repository.BancoRepository;
import com.stefanini.repository.SucursalRepository;
import com.stefanini.rest.dto.SucursalDTO;
import com.stefanini.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {

	@Inject
	private SucursalRepository sucursalRepository;

	@Inject
	private BancoRepository bancoRepository;

	@Override
	public Sucursal create(SucursalDTO sucursalDTO) {
		Optional<Banco> bancoOp = bancoRepository.findById(sucursalDTO.getIdBanco());

		if (bancoOp.isPresent()) {
			Sucursal sucursal = Sucursal.builder()
					.banco(bancoOp.get())
					.nombre(sucursalDTO.getNombre())
					.direccion(sucursalDTO.getDireccion())
					.fechaRegistro(sucursalDTO.getFechaRegistro())
					.build();

			return sucursalRepository.saveAndFlush(sucursal);
		}

		return null;
	}

	@Override
	public Sucursal update(SucursalDTO sucursalDTO) {
		Optional<Sucursal> sucursalOp = sucursalRepository.findById(sucursalDTO.getIdSucursal());

		if (sucursalOp.isPresent()) {
			Sucursal sucursal = sucursalOp.get();

			sucursal.setNombre(sucursalDTO.getNombre());
			sucursal.setDireccion(sucursalDTO.getDireccion());
			
			return sucursalRepository.saveAndFlush(sucursal);
		}

		return null;
	}

	@Override
	public boolean deleteById(Long idSucursal) {
		boolean flag = true;

		try {
			sucursalRepository.deleteById(idSucursal);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Sucursal> getSucursales() {
		return sucursalRepository.findAll();
	}

	@Override
	public List<Sucursal> getSucursalByIdBanco(Long idBanco) {
		return sucursalRepository.findAllByBancoIdBanco(idBanco);
	}

}
