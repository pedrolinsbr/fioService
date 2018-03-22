package br.com.furukawa.factory;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe responsável para conexao com o banco, e fechamento
 * @author pedro.neto
 *
 */

public class ConnectionFactory {
	private static final String DRIVER= "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	private static final String URL = "jdbc:microsoft:sqlserver://10.0.0.15;databaseName=ERP_FURUKAWA_OFICIAL";
	private static final String USER = "JAVA";
	private static final String PASSWORD = "pk6HHmg40";

	public Connection criarConexao(){
		Connection conn=null;
		try {
			Class driverClass = Class.forName(DRIVER);
			DriverManager.registerDriver((Driver) driverClass.newInstance());
			conn =  DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.out.println("Erro ao criar conexão com o banco: "+URL);
			e.printStackTrace();
		}
		return conn; 
	}
	
	public void fecharConexao(Connection conn, PreparedStatement pstmt, ResultSet rs){
		
		try {
			if(conn != null){
				conn.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexão com o banco: "+URL);
			e.printStackTrace();
		}
	}
}
