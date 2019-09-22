package br.com.crudjavaee.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes().openSession();
		
	}

	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes().close();
		
	}


}
