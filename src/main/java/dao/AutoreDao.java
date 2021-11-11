package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Autore;

@Model
public class AutoreDao {
	@PersistenceContext(unitName = "persistenceUnit1")
	private EntityManager em;

	//Override
	public Autore get(int id) {
		return em.find(Autore.class, id);
	}

	//Override
	public List<Autore> getAll() {
		return em.createNamedQuery("findAllAutori", Autore.class).getResultList();
	}
	

	//	@Override
	public void save(Autore autoreInput) {
		//Autore esiste nel DB?
		Autore autoreEsistente = em.find(Autore.class, autoreInput.getId());
		if(autoreEsistente != null) {
			// entita gia esiste nel DB
			autoreEsistente.setEta(autoreInput.getEta());
			autoreEsistente.setNome(autoreInput.getNome());
			autoreEsistente.setCognome(autoreInput.getCognome());
			em.merge(autoreEsistente);

		} else {
			// entita prima volta che la vedo nel DB!
			em.persist(autoreInput);
		}
	}
	
	public void save(String nome, String cognome, int id,int eta) {
		//autore esiste nel DB?
		Autore autoreEsistente = em.find(Autore.class, id);
		if(autoreEsistente != null) {
			// entita gia esiste nel DB
			autoreEsistente.setEta(eta);
			autoreEsistente.setNome(nome);
			autoreEsistente.setCognome(cognome);
			em.merge(autoreEsistente);

		} else {
			// entita prima volta che la vedo nel DB!
			Autore autoreToSave = new Autore();
			autoreEsistente.setEta(eta);
			autoreToSave.setNome(nome);
			autoreToSave.setCognome(cognome);
			autoreToSave.setId(id);
			em.persist(autoreToSave);
		}
	}
	//Override
	public void delete(Autore autore) {
		em.remove(autore);
	}

	//Override
	public void update(Autore t) {
		em.merge(t);
		
	}


}
