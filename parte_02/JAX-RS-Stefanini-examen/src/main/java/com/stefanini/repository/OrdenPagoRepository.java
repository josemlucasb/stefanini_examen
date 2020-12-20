package com.stefanini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.domain.OrdenPago;

public interface OrdenPagoRepository extends JpaRepository<OrdenPago, Long> {

	List<OrdenPago> findAllBySucursalIdSucursalAndMoneda(Long idSucursal, String moneda);

}
