package com.learn;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.learn.model.Customer;

public class TestSystem {
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("30062019-JPQL-tutorial");
	
	public static void main(String[] args) {
		addCustomer(1, "cao1", "minh duc1");
		addCustomer(2, "cao2", "minh duc2");
		addCustomer(3, "cao3", "minh duc3");
		addCustomer(4, "cao4", "minh duc4");
		addCustomer(5, "cao5", "minh duc5");
		System.out.println("Get");
		getCustomer(1);
		changeFirstName(1, "minhducitus");
		deleteCustomer(3);
		entityManagerFactory.close();
	}
	
	public static void addCustomer(int id, String firstname, String lastname) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = null;
		try {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Customer customer = new Customer();
			customer.setId(id);
			customer.setFirstName(firstname);
			customer.setLastName(lastname);
			entityManager.merge(customer);
			entityTransaction.commit();
		} catch (Exception ex) {
			if (entityTransaction != null) {
				entityTransaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			entityManager.close();
		}
	}
	
	public static void getCustomer(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String query = "SELECT c FROM Customer c WHERE c.id = :custID";
		
		TypedQuery<Customer> typedQuery = entityManager.createQuery(query, Customer.class);
		typedQuery.setParameter("custID", 1);
		
		Customer result = null;
		try {
			result = typedQuery.getSingleResult();
			System.out.println(result.getFirstName() + " " + result.getLastName());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}
	
	public static void getAllCustomers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String query = "SELECT c FROM Customer c WHERE c.id IS NOT NULL";
		
		TypedQuery<Customer> typedQuery = entityManager.createQuery(query, Customer.class);
		List<Customer> resultList;
		try {
			resultList = typedQuery.getResultList();
			resultList.forEach(cust->System.out.println(cust.getId() + " " + cust.getFirstName() + " " + cust.getLastName()));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}
	
	public static void changeFirstName(int id, String firstName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = null;
		
		Customer resultCust = null;
		try {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			resultCust = entityManager.find(Customer.class, id);
			resultCust.setFirstName(firstName);
			
			entityManager.persist(resultCust);
			entityTransaction.commit();
		}
		catch (Exception e) {
			if (entityTransaction != null) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}
	
	public static void deleteCustomer(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = null;
		
		try {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			Customer needle = entityManager.find(Customer.class, id);
			entityManager.remove(needle);
			
			entityTransaction.commit();
		}
		catch (Exception e) {
			if (entityTransaction != null) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> findWithFirstName(String firstName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.createQuery("SELECT c FROM Customer WHERE c.name LIKE :custFirstName")
				.setParameter("custFirstName", firstName)
				.setMaxResults(10)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomerWithLastName(String lastName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.createNamedQuery("findAllCustomerWithName")
				.setParameter("custFirstName", lastName)
				.getResultList();
	}
	
	public Customer findCustomerWithLastName(String lastName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String query = "SELECT c FROM Customer c WHERE c.last_name LIKE ?1";
		
		TypedQuery<Customer> typedQuery = entityManager.createQuery(query, Customer.class);
		typedQuery.setParameter(1, lastName);
		Customer resultCustomer = new Customer();
		try {
			resultCustomer = typedQuery.getSingleResult();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		return resultCustomer;
	}
}
