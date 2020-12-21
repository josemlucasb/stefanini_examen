package com.stefanini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.domain.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

	List<Sucursal> findAllByBancoIdBanco(Long idBanco);

}
