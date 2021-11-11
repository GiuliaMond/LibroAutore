package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Autore;
import model.Libro;

import javax.persistence.Query;

public class LibroDao implements Dao<Libro>{
	
	@PersistenceContext(unitName = "persistenceUnit1")
	private EntityManager em;

	@Override
	public Libro get(int id) {
		return em.find(Libro.class, id);
	}

	@Override
	public List<Libro> getAll() {
		return em.createNamedQuery("findAllLibri", Libro.class)
				.getResultList();
	}
	
	@Override
	public void save(Libro libro) {
		
	}
	
	@Override
	public void delete(Libro libro) {
		em.remove(libro);
	}

	public List<Autore> getByName(String titolo) {
		Query query= em.createNativeQuery("select * from autore where nome=:parametroTitolo ");
		query.setParameter("parametroTitolo", titolo);
		
		List<Autore> libri=query.getResultList();
		return libri;
	}

	@Override
	public void update(Libro t, String[] params) {
		// TODO Auto-generated method stub
		
	}

}
