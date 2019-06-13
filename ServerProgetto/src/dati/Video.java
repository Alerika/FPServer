package dati;

import java.io.Serializable;

public class Video implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String titolo;
	private String genere;
	private int anno;
	private String descrizione;
	private String link;
	
	public Video(){}

	public Video(String titolo, String genere, int anno, String descrizione, String link)
	{
		super();
		this.titolo = titolo;
		this.genere = genere;
		this.anno = anno;
		this.descrizione = descrizione;
		this.link = link;
	}

	public String getTitolo(){return titolo;}
	public void setTitolo(String titolo){this.titolo = titolo;}

	public String getGenere(){return genere;}
	public void setGenere(String genere){this.genere = genere;}

	public int getAnno(){return anno;}
	public void setAnno(int anno){this.anno = anno;}

	public String getDescrizione(){return descrizione;}
	public void setDescrizione(String descrizione){this.descrizione = descrizione;}

	public String getLink(){return link;}
	public void setLink(String link){this.link = link;}	
}
