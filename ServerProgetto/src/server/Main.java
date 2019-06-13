package server;

import java.io.IOException;
import java.sql.SQLException;

import database.DataBase;

public class Main
{
	public static void main(String[] args) throws IOException, SQLException
	{
		Server server = new Server();
		server.avvia();
		
		DataBase.creaConnessione();
	}	
}
