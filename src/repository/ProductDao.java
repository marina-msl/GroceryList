package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Product;

//https://www.devmedia.com.br/jpa-e-hibernate-acessando-dados-em-aplicacoes-java/32711

public class ProductDao {

	private static ProductDao instance;
	protected EntityManager entityManager;
	

	public static ProductDao getInstance() {
		if (instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}
	
	private ProductDao() {
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("grocery");

		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public Product getById(final int id) {
		return entityManager.find(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		return entityManager.createQuery("from " +  Product.class.getName()).getResultList();
	}

	public void saveProduct(Product product) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(product);
		this.entityManager.getTransaction().commit();
	}

}
