package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.SQLException;

import database.DataBase;

public class GestoreConnessione implements Runnable
{
	private Socket socket;

	public GestoreConnessione(Socket socket){this.socket = socket;}
	
	public String usernameLibero() throws IOException, ClassNotFoundException, SQLException
	{
		System.out.println("ho ricevuto qualcosa!!");
		
		InputStream istream = socket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(istream));
		String risultato = in.readLine();
		socket.close();
		if(DataBase.controllaUsername(risultato))
			return risultato;
		
//		System.err.println("User: "+ risultato);
		return "";
	}
	
	public String registrazione() throws IOException, SQLException
	{
		InputStream istream = socket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(istream));
		String nome = in.readLine();
		String cognome = in.readLine();
		String data = in.readLine();
		String mail = in.readLine();
		String username = in.readLine();
		String password = in.readLine();
		socket.close();
		if(DataBase.inserisciUtente(nome, cognome, data, mail, username, password))
			return "";
		return username;
	}
	
	@Override
	public void run()
	{
		try
		{
			usernameLibero();
		} 
		catch (ClassNotFoundException | IOException | SQLException e)
		{e.printStackTrace();}
	}

}
