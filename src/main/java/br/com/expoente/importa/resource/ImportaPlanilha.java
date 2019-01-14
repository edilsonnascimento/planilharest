/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.expoente.importa.resource;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author ednascimento
 */
@Path("importacao")
public class ImportaPlanilha {
	
	
	@PUT	
	public Response alteraProduto() {
		
		return Response.ok().build();
	}
}
