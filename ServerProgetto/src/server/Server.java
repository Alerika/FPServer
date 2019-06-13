package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server implements Runnable
{
	private ServerSocket server = null;
	
	public Server() {}
	
	public void avvia() throws IOException, SQLException
	{
		server = new ServerSocket(8000);
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Socket socket = server.accept();
				GestoreConnessione g = new GestoreConnessione(socket);
				Thread t = new Thread(g);
				t.start();
			}
			catch (IOException e){e.printStackTrace();}
		}
	}
	/*
	public static void main(String[] args) throws IOException, SQLException {
		Server server = new Server();
		server.avvia();
	}*/
}
