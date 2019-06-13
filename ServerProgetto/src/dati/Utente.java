package dati;

//import java.io.File;
import java.io.Serializable;

//import javafx.stage.FileChooser;
//import javafx.stage.Stage;

public class Utente implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cognome;
	private String data; //data di nascita
	private String mail;
	private String username;
	private String password;
//	private String imgProfilo; //percorso del file
	
	
	public Utente(){}

	public Utente(String nome, String cognome, String data, String mail, String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data = data;
		this.mail = mail;
		this.username = username;
		this.password = password;
//		imgProfilo = "risorse" + File.separator + "avatar.png";
	}

	public String getNome(){return nome;}
	public void setNome(String nome){this.nome = nome;}

	public String getCognome(){return cognome;}
	public void setCognome(String cognome){this.cognome = cognome;}

	public String getData(){return data;}
	public void setData(String data){this.data = data;}

	public String getMail(){return mail;}
	public void setMail(String mail){this.mail = mail;}

	public String getUsername(){return username;}
	public void setUsername(String username){this.username = username;}

	public String getPassword(){return password;}
	public void setPassword(String password){this.password = password;}
	
/*	public void setFotoProfilo(Stage stage)
	{
		
	}*/
}
