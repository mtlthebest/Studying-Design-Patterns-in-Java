import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Emp;

public class DBAccess {

	private static DBAccess instance = new DBAccess();

	private SessionFactory sessionfactory;
	private Session session;
	
	public static DBAccess getInstance() {
		return instance;
	}

	private DBAccess() {
		Configuration config = new Configuration();
		config = config.configure(); // ê›íËÇÃì«Ç›çûÇ›
		sessionfactory = config.buildSessionFactory();

	}
	
	@SuppressWarnings("unchecked")
	public List<Emp> findAllEmp(){
		return session.createCriteria(Emp.class).list();		
	}
	
	
	public void openSession(){
		session = sessionfactory.openSession();
	}

	public void close(){
		session.close();
		sessionfactory.close();
	}
}
