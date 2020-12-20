package com.stefanini.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ordenpago")
public class OrdenPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ordenpago")
	private Long idOrdenpago;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sucursal")
	private Sucursal sucursal;

	@Column(name = "monto", nullable = false)
	private Double monto;

	@Column(name = "moneda", nullable = false)
	private String moneda;

	@Column(name = "estado", nullable = false)
	private Integer estado;

	@Column(name = "fecha_pago", nullable = false)
	private Date fechaPago;

}
