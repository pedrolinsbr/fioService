package br.com.furukawa.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.furukawa.factory.ConnectionFactory;
import br.com.furukawa.model.Funcionario;;

/**
 * Classe responsavel por metodos do crud de Funcionario 
 * @author pedro.neto
 *
 */
public class FuncionarioDAO extends ConnectionFactory{
	
	private static FuncionarioDAO instance;
	
	/**
	 * Metodo responsavel por criar uma instancia da classe FuncionaroDAO (Singlelon)
	 * @return
	 */
	public static FuncionarioDAO getInstance(){
		if(instance == null){
			instance = new FuncionarioDAO();
		}
		return instance;
		
	}
	public ArrayList<Funcionario> listarTodos() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		ArrayList<Funcionario> funcionarios= null;
		conn = criarConexao();
		try {
			pstmt = conn.prepareStatement(" select *from SRA010 ");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Funcionario funcionario = new Funcionario();
				funcionario.setMatricula(rs.getString("RA_MAT"));
				funcionario.setNome(rs.getString("RA_NOME"));
				funcionario.setRg(rs.getString("RA_RG"));
				funcionario.setCpf(rs.getString("RA_CIC"));
				funcionario.setCc(rs.getString("RA_CC"));
				funcionario.setCargo(rs.getString("RA_ADESCFU"));
				funcionarios.add(funcionario);
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos funcioanrios");
			e.printStackTrace();
		}finally {
			fecharConexao(conn, pstmt, rs);
		}
		
		return funcionarios;
		
	}
}
