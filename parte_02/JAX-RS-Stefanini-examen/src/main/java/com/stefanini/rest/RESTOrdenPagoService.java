package com.stefanini.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.rest.dto.OrdenPagoDTO;
import com.stefanini.service.OrdenPagoService;

@Path("/ordenpago")
public class RESTOrdenPagoService {

	@Inject
	private OrdenPagoService ordenPagoService;

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(OrdenPagoDTO ordenPagoDTO) {
		return Response.status(Response.Status.OK).entity(ordenPagoService.create(ordenPagoDTO)).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(OrdenPagoDTO ordenPagoDTO) {
		return Response.status(Response.Status.OK).entity(ordenPagoService.update(ordenPagoDTO)).build();
	}

	@DELETE
	@Path("/delete/{idOrdenPago}")
	public Response deleteById(@PathParam("idOrdenPago") Long idOrdenPago) {
		return Response.status(Response.Status.OK).entity(ordenPagoService.deleteById(idOrdenPago)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrdenesPago() {
		return Response.status(Response.Status.OK).entity(ordenPagoService.getOrdenesPago()).build();
	}

	@GET
	@Path("/findBySucursalId/{idSucursal}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrdenesBySucursalIdAndMoneda(@PathParam("idSucursal") Long idSucursal, @QueryParam("moneda") String moneda) {
		return Response.status(Response.Status.OK).entity(ordenPagoService.getOrdenesByFiltros(idSucursal, moneda)).build();
	}

}
