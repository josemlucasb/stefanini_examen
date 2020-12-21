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

import com.stefanini.rest.dto.BancoDTO;
import com.stefanini.service.BancoService;

@Path("/banco")
public class RESTBancoService {

	@Inject
	private BancoService bancoService;

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(BancoDTO bancoDTO) {
		return Response.status(Response.Status.OK).entity(bancoService.create(bancoDTO)).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(BancoDTO bancoDTO) {
		return Response.status(Response.Status.OK).entity(bancoService.update(bancoDTO)).build();
	}

	@DELETE
	@Path("/delete/{idBanco}")
	public Response deleteById(@PathParam("idBanco") Long idBanco) {
		return Response.status(Response.Status.OK).entity(bancoService.deleteById(idBanco)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBancos() {
		return Response.status(Response.Status.OK).entity(bancoService.getBancos()).build();
	}

}
