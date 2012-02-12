import java.util.Date;

import org.junit.Test;

import command.DBAccess;

import entity.Emp;

import junit.framework.TestCase;


public class DBAccessTest extends TestCase{
	
	
	DBAccess dbAccess = DBAccess.getInstance();
	
	
	@Test
	public void testInsert(){
		Emp emp = new Emp();
		emp.setEname("hoge");
		emp.setHiredate(new Date());
		emp.setJob("fuga");
		System.out.println(dbAccess.insert(emp));
		System.out.println(dbAccess.findAllEmp());
	}
	
	@Test
	public void testLoad(){
		System.out.println(dbAccess.findAllEmp());
		System.out.println(dbAccess.load(1));
		System.out.println(dbAccess.load(2));
		
	}
	
	@Test
	public void testDelete(){
		System.out.println("Before:"+dbAccess.findAllEmp());		
		dbAccess.delete(1);
		System.out.println("After: "+dbAccess.findAllEmp());		
	}
	
	@Test
	public void testUpdate(){
		Emp emp = dbAccess.load(2);
		System.out.println("Before:"+emp);
		emp.setJob("new "+emp.getJob());
		dbAccess.update(emp);
		System.out.println("After: "+dbAccess.load(2));
	}

}
