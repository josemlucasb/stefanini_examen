package com.stefanini.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.stefanini.domain.Banco;
import com.stefanini.repository.BancoRepository;
import com.stefanini.rest.dto.BancoDTO;
import com.stefanini.service.BancoService;

@Service
public class BancoServiceImpl implements BancoService {

	@Inject
	private BancoRepository bancoRepository;

	@Override
	public Banco create(BancoDTO bancoDTO) {
		Banco banco = Banco.builder()
				.nombre(bancoDTO.getNombre())
				.direccion(bancoDTO.getDireccion())
				.fechaRegistro(bancoDTO.getFechaRegistro())
				.build();
		
		return bancoRepository.saveAndFlush(banco);
	}

	@Override
	public Banco update(BancoDTO bancoDTO) {
		Optional<Banco> bancoOp = bancoRepository.findById(bancoDTO.getIdBanco());
		
		if (bancoOp.isPresent()) {
			Banco banco = bancoOp.get();
			
			banco.setNombre(bancoDTO.getNombre());
			banco.setDireccion(bancoDTO.getDireccion());
			
			return bancoRepository.saveAndFlush(banco);
		}
		
		return null;
	}

	@Override
	public boolean deleteById(Long idBanco) {
		boolean flag;
		
		try {
			bancoRepository.deleteById(idBanco);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Banco> getBancos() {
		return bancoRepository.findAll();
	}

}
