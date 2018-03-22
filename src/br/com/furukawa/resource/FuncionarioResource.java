package br.com.furukawa.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.furukawa.controller.FuncionarioController;
import br.com.furukawa.model.Funcionario;

/**
 * Classe responsavel por conter o metodo de acesso ao webservice
 * @author pedro.neto
 *
 */

@Path("/funcionario")
public class FuncionarioResource {
	
	/**
	 * Método responsavel por fazer a chamada ao controller
	 * @return Arraylist<Funcionario> 
	 */
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<Funcionario> listarTodos(){
		return new FuncionarioController().listarTodos();
	}
	
	
}
