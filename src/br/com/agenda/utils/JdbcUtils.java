package br.com.agenda.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	private static Connection myconn;

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/tutorial";
	private String usuario = "root";
	private String senha = "root";
	
	private JdbcUtils() throws SQLException{
		
		if(myconn == null){
			
			try {
				Class.forName(driver);
				myconn=DriverManager.getConnection(url, usuario, senha);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
	}
	
	public static Connection getInstance(){
		if(myconn == null){
			
			try {
				new JdbcUtils();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Realizando conexao !");
			
		} else {
			
			System.out.println("Conectado com sucesso !");
		}
		
		return myconn;
	}
	

}
