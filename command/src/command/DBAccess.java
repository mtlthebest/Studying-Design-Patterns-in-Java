package command;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		openSession();
	}
	
	public Integer insert(Emp emp) {
		Transaction t = session.beginTransaction(); 
		session.save(emp);
		t.commit();
		return emp.getEmpno();
	}
	
	public void delete(int id){
		Emp emp = (Emp)session.load(Emp.class, new Integer(id));
		session.delete(emp);
	}
	
	public Emp load(int id){
		return (Emp)session.load(Emp.class, new Integer(id));
	}
	
	public void update(Emp emp){
		Transaction t = session.beginTransaction();
		session.update(emp);
		t.commit();
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
	@Override
	public void finalize(){
		close();
	}
}
