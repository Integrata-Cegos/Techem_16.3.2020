package de.techem.lukas.store.library.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabaseStoreService implements de.techem.lukas.store.library.api.StoreService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int getStock(String category, String item) {
		Query query = entityManager.createNativeQuery("select stock from store where category = :cat and item = :item");
		query.setParameter("cat", category);
		query.setParameter("item", item);
		try {
			Integer result = (Integer) query.getSingleResult();
			return result;
		} catch (Exception e) {
			return 0; 
		}
	}


}
