package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase 
{
	private static Connection con = null;
	
	public static void creaConnessione()
	{
		String url = "jdbc:sqlite:database.db";
		try {
			con = DriverManager.getConnection(url);
			if(con != null && !con.isClosed())
				System.out.println("Connesso");
		} catch (SQLException e) {
			System.err.println("errore connessione");
		}
	}
	
	public static boolean controlloAccesso(String username, String password) {
		try {
			if (con == null || con.isClosed())
				return false;
			String query = "SELECT password FROM utenti WHERE username=?";
			PreparedStatement state = con.prepareStatement(query);
			state.setString(1, username);
			ResultSet rs = state.executeQuery();
			String passwd = null;
			while (rs.next())
			{
				passwd = rs.getString("password");
			}
			state.close();
			if (passwd == null)
				return false;
			return passwd.equals(password);
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean inserisciUtente(String nome, String cognome, String data, String mail, String username, String password) throws SQLException
	{
		if(con == null || con.isClosed()) return false;
		String query = "INSERT INTO Utenti VALUES(?,?,?,?,?,?)";
		PreparedStatement state = con.prepareStatement(query);
		state.setString(1, nome);
		state.setString(2, cognome);
		state.setString(3, data);
		state.setString(4, mail);
		state.setString(5, username);
		state.setString(6, password);
		state.executeUpdate();
		state.close(); 
		return true;
	}

	//controlla se lo username � presente
	public static boolean controllaUsername(String username) throws SQLException
	{
		if(con == null || con.isClosed()) return false;
		String query = "SELECT * FROM Utenti WHERE username = ?";
		PreparedStatement state = con.prepareStatement(query);
		state.setString(1, "username");
		ResultSet res = state.executeQuery();
		if(!res.next())
			return true;
		return false;
	}
	 
	public static void chiudiConnessione() throws SQLException
	{
		if (con != null && !con.isClosed())
		{
			con.close();
			con = null;
		}
	}
}
