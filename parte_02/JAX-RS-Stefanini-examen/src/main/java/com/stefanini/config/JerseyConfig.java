package com.stefanini.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.stefanini.rest.RESTBancoService;
import com.stefanini.rest.RESTOrdenPagoService;
import com.stefanini.rest.RESTSucursalService;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(RESTBancoService.class);
		register(RESTSucursalService.class);
		register(RESTOrdenPagoService.class);
	}

}
