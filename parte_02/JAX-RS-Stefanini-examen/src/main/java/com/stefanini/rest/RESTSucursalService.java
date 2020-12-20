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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.rest.dto.SucursalDTO;
import com.stefanini.service.SucursalService;

@Path("/sucursal")
public class RESTSucursalService {

	@Inject
	private SucursalService sucursalService;

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(SucursalDTO sucursalDTO) {
		System.out.println("+-create()");
		return Response.status(Response.Status.OK).entity(sucursalService.create(sucursalDTO)).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(SucursalDTO sucursalDTO) {
		System.out.println("+-update()");
		return Response.status(Response.Status.OK).entity(sucursalService.update(sucursalDTO)).build();
	}

	@DELETE
	@Path("/delete/{idSucursal}")
	public Response deleteById(@PathParam("idSucursal") Long idSucursal) {
		System.out.println("+-deleteById() idSucursal: " + idSucursal);
		return Response.status(Response.Status.OK).entity(sucursalService.deleteById(idSucursal)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSucursales() {
		System.out.println("+-getSucursales()");
		return Response.status(Response.Status.OK).entity(sucursalService.getSucursales()).build();
	}

}
