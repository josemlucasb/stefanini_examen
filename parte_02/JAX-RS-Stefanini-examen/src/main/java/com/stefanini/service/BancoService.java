package com.stefanini.service;

import java.util.List;

import com.stefanini.domain.Banco;
import com.stefanini.rest.dto.BancoDTO;

public interface BancoService {

	Banco create(BancoDTO bancoDTO);

	Banco update(BancoDTO bancoDTO);

	boolean deleteById(Long idBanco);

	List<Banco> getBancos();

}
