import java.util.List;

import entity.Emp;


public class Client {

	public static void main(String[] args){
		DBAccess dbAccess = DBAccess.getInstance();
		dbAccess.openSession();
		List<Emp> allEmp = dbAccess.findAllEmp();
		for(Emp emp : allEmp){
			System.out.println(emp.toString());
		}
		dbAccess.close();
		

	}
}