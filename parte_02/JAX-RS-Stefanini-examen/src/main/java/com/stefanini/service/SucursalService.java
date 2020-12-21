package com.stefanini.service;

import java.util.List;

import com.stefanini.domain.Sucursal;
import com.stefanini.rest.dto.SucursalDTO;

public interface SucursalService {

	Sucursal create(SucursalDTO sucursalDTO);

	Sucursal update(SucursalDTO sucursalDTO);

	boolean deleteById(Long idSucursal);

	List<Sucursal> getSucursales();

	List<Sucursal> getSucursalByIdBanco(Long idBanco);

}
