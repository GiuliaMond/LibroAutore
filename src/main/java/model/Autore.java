package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//to insert in postgres
@Entity
@Table(name = "autore")
@NamedQuery(
	    name="findAllAutori",
	    query="SELECT a FROM Autore a"
	
		)
public class Autore implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(nullable=false, name="id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, name="nome")
	private String nome;
	
	@Column(nullable=false, name="cognome")
	private String cognome;
	
	@Column(nullable=false, name="eta")
	private Integer eta;
	
	/*@OneToMany(mappedBy="autore")
	private List<Libro> libri;*/
	 
	// devo prima mettere un costruttore vuoto perche richiede cio
	public Autore() {
		
	}
	/*
	public Autore(int id, String nome, String cognome, Integer eta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}
	

	@Override
	public String toString() {
		return "Autore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "eta " +"]";
	}
	
}
