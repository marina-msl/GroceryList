package Application;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entities.Product;

public class Test {
	
	public static void main(String[] args) {
		
		Product product = new Product("Banana", 8.90, 3);

		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("grocery");
		EntityManager em = factory.createEntityManager();
		
		em.persist(product);
		
	}

}
