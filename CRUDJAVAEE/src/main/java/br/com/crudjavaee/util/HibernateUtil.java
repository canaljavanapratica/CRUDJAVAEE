package br.com.crudjavaee.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	 
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes(); 

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}
	private static SessionFactory criarFabricaDeSessoes() {
		try {
			Configuration configuracao = new Configuration().configure(); 
			
			@SuppressWarnings("unused") 
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			SessionFactory fabrica = configuracao.buildSessionFactory();
			return fabrica;
		} catch (Exception ex) {
			System.err.println("Não foi possível criar a fábrica de sessões ! erro: " + ex);
            throw new ExceptionInInitializerError(ex);
		}
	} 
	
	
}
