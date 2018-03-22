package br.com.furukawa.controller;

import java.util.ArrayList;

import br.com.furukawa.dao.FuncionarioDAO;
import br.com.furukawa.model.Funcionario;
import sun.security.jca.GetInstance;

/**
 * Classe responsavel por ser o controlador entre o resource e a camada DAO
 * @author pedro.neto
 *
 */
public class FuncionarioController {
	
	public ArrayList<Funcionario> listarTodos(){
		return FuncionarioDAO.getInstance().listarTodos();
	}

}
