package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//to insert in postgres
@Entity
@Table(name = "libro")
@NamedQuery(
	    name="findAllLibri",
	    query="SELECT l FROM Libro l"
	
		)

public class Libro {
	
	@Id 
	@Column(nullable=false, name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, name="titolo")
	private String titolo;
	
	@Column(nullable=false, name="numero_pagine")
	private int numero_pagine;
	
	/*
	 * @Column(nullable=false, name="autore_id")
		private int autore_id;
		*/
	
	/*@ManyToOne
	@JoinColumn(name="autore_id")
	private Autore autore; // cosa metto in mappedBy*/
	
	public Libro() {
	}
/*
	public Libro(int id, String titolo, int numero_pagine) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.numero_pagine = numero_pagine;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getNumero_pagine() {
		return numero_pagine;
	}

	public void setNumero_pagine(int numero_pagine) {
		this.numero_pagine = numero_pagine;
	}
	/*
	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	*/
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titolo "+ titolo +", numero pagine" + numero_pagine +"]";
	}

	
}
