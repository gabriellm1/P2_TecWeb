package br.insper.noteblock.model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {
	
private Connection connection = null;

public DAO() {
	
	 try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		connection = DriverManager.getConnection(
		"jdbc:mysql://localhost/EventNote", "root", "tecweb");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public List<Notas> getLista() {
		List<Notas> notas = new ArrayList<Notas>();
		try {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Notas");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Notas nota = new Notas();
			nota.setId(rs.getInt("id"));
			nota.setIduser(rs.getInt("userid"));
			nota.setNome(rs.getString("nome"));
			Calendar data = Calendar.getInstance();
			nota.setDescri(rs.getString("descri"));
			data.setTime(rs.getDate("data"));
			nota.setData(data);
			notas.add(nota);
		
		}

	rs.close();
	stmt.close();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	return notas;
}
	
	
	public List<Notas> getFilter(String date1,String date2){
		
		String sql = "SELECT * FROM Notas WHERE  data between  ? and ?";



		
		List<Notas> notas = new ArrayList<Notas>();
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);

		
		stmt.setString(1,date1);
		stmt.setString(2,date2);
		
		ResultSet rs = stmt.executeQuery();

		
		while (rs.next()) {
			Notas nota = new Notas();
			nota.setId(rs.getInt("id"));
			nota.setIduser(rs.getInt("userid"));
			nota.setNome(rs.getString("nome"));
			Calendar data = Calendar.getInstance();
			nota.setDescri(rs.getString("descri"));
			data.setTime(rs.getDate("data"));
			nota.setData(data);
			notas.add(nota);
		}

	rs.close();
	stmt.close();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	return notas;
}
	
	
	public void adiciona(Notas nota) {
		String sql = "INSERT INTO Notas" +
		"(nome,data,descri,userid) values(?,?,?,?)";
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,nota.getNome());
		stmt.setDate(2, new java.sql.Date(
				nota.getData().getTimeInMillis()));
		stmt.setString(3,nota.getDescri());
		stmt.setInt(4,nota.getIduser());
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	
	public boolean addUser(Usuario usuario) {
		boolean existe = false;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Usuarios");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Usuario usuariox = new Usuario();
			usuariox.setId(rs.getInt("id"));
			usuariox.setUser(rs.getString("user"));
			usuariox.setSenha(rs.getString("senha"));
			usuarios.add(usuariox);		
		}
		rs.close();
		stmt.close();}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		for(int i=0; i < usuarios.size(); i++){
			if (usuarios.get(i).getUser().equals(usuario.getUser()) && usuarios.get(i).getSenha().equals(usuario.getSenha())){
				existe = true;
			}}
		if(!(existe)) {
			String sql = "INSERT INTO Usuarios" +
					"(user,senha) values(?,?)";
			try {
			PreparedStatement stmt2 = connection.prepareStatement(sql);
			stmt2.setString(1,usuario.getUser());
			stmt2.setString(2,usuario.getSenha());
			stmt2.execute();
			stmt2.close();}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			
			
		}
		return existe;
	}
		
		

	

	
	
	public void altera(Notas nota) {
		String sql = "UPDATE Notas SET " +
		 "nome=?, data=? ,descri=? WHERE id=?";
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, nota.getNome());
		stmt.setDate(2, new Date(nota.getData()
				.getTimeInMillis()));
		stmt.setString(3,nota.getDescri());
		stmt.setInt(4, nota.getId());
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	
	
	public void altUser(Usuario usuario) {
		String sql = "UPDATE Usuarios SET " +
		 "user=?, senha=? WHERE id=?";
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, usuario.getUser());
		stmt.setString(2,usuario.getSenha());
		stmt.setInt(3, usuario.getId());
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	
	
	public void remove(Integer id) {
		try {
		PreparedStatement stmt = connection
		 .prepareStatement("DELETE FROM Notas WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	
	
	public void remUser(Integer id) {
		try {
		PreparedStatement stmt1 = connection
		 .prepareStatement("DELETE FROM Notas WHERE userid=?");
		PreparedStatement stmt2 = connection
				 .prepareStatement("DELETE FROM Usuarios WHERE id=?");
		stmt1.setLong(1, id);
		stmt1.execute();
		stmt1.close();
		stmt2.setLong(1, id);
		stmt2.execute();
		stmt2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	

	public Integer login(Usuario usuario) {
		Integer userid = null;
		String sql = "SELECT user, senha, id FROM Usuarios WHERE user = ? AND senha = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getUser());
			stmt.setString(2,usuario.getSenha());
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				  String username = rs.getString("user");
				  String usersenha = rs.getString("senha");
				  String useridstring = rs.getString("id");
			if (usuario.getUser().equals(username) && usuario.getSenha().equals(usersenha)){
				userid = Integer.parseInt(useridstring);}
			}
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		return userid;
		}
	
	public Usuario showUser(Integer id) {
		Usuario usuario = new Usuario();
		String sql = "SELECT user, senha FROM Usuarios WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				usuario.setUser(rs.getString("user"));
				usuario.setSenha(rs.getString("senha"));
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		return usuario ;
		}

	
	
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}