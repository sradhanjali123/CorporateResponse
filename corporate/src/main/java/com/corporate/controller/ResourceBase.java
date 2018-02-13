package com.corporate.controller;

import javax.naming.NamingException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum ResourceBase {
	INSTANCE;
	private EntityManagerFactory emf;

	private ResourceBase() {
		emf = Persistence.createEntityManagerFactory("corp");
	}

	public EntityManager getEntityManager() throws NamingException {
		return emf.createEntityManager();
	}
	
	public void close(){
		emf.close();
	}
}