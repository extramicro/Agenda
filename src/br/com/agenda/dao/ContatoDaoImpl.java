package br.com.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.model.Contato;
import br.com.agenda.utils.JdbcUtils;

public class ContatoDaoImpl implements ContatoDao {
	
JdbcUtils con;

ResultSet rs;

@Override
public void inserirContato(Contato c) {
	
String sql="INSERT INTO contato (nome,endereco,telefone) VALUES (?,?,?)";

	try {
		PreparedStatement ps = JdbcUtils.getInstance().prepareStatement(sql);
		
		ps.setString(1, c.getNome());
		ps.setString(2, c.getEndereco());
		ps.setString(3, c.getTelefone());
		
		int i = ps.executeUpdate();
		
		if(i != 0) {
			
			System.out.println("Contato inserido com sucesso !");
			
		} else {
			
			System.out.println("Erro ao inserir contato !");
		}
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

@Override
public void alterarContato(Contato c) {
	
	String sql="UPDATE contato SET nome=?,endereco=?,telefone=? WHERE id=?";

	try {
		PreparedStatement ps = con.getInstance().prepareStatement(sql);
		
		ps.setString(1, c.getNome());
		ps.setString(2, c.getEndereco());
		ps.setString(3, c.getTelefone());
		ps.setInt(4, c.getId());
		
		int i = ps.executeUpdate();
		
		if(i != 0) {
			
			System.out.println("Contato alterado com sucesso !");
			
		} else {
			
			System.out.println("Erro ao alterar contato !");
		}
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}

@Override
public void excluirContato(int id) {
	
String sql = "DELETE FROM contato WHERE id=?";
	

try {
	PreparedStatement ps = con.getInstance().prepareStatement(sql);
	

	ps.setInt(1, id);
	
	int i = ps.executeUpdate();
	
	if(i != 0) {
		
		System.out.println("Contato excluido com sucesso !");
		
	} else {
		
		System.out.println("Erro ao excluir contato !");
	}
		
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}

@Override
public List<Contato> ListarContatos() {
	
String sql ="SELECT * FROM contato";
	
List<Contato> ListContato = new ArrayList<Contato>();

PreparedStatement ps;

try {
	ps = con.getInstance().prepareStatement(sql);
	rs = ps.executeQuery();
	
	while(rs.next()){
		
		Contato c = new Contato();
		
		c.setNome(rs.getString("nome"));
		c.setEndereco(rs.getString("endereco"));
		c.setTelefone(rs.getString("telefone"));
		c.setId(rs.getInt("id"));
		
		ListContato.add(c);
		
	}
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


	
	return ListContato;
}




}
