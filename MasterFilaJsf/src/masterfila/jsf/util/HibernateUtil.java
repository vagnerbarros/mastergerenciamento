package masterfila.jsf.util;

import masterfila.jsf.entidade.Estabelecimento;
import masterfila.jsf.entidade.Funcionario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		
		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(Estabelecimento.class);
		configuration.addAnnotatedClass(Funcionario.class);
		
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

}