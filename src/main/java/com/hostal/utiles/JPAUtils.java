package com.hostal.utiles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
private static EntityManagerFactory FACTORY=Persistence.createEntityManagerFactory("hostal");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
		
	}
}
