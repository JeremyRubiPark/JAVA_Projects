package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import repository.DepartmentDao;
import vo.DepartmentVO;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext("/xml/applicationContext.xml");
		
		DepartmentDao dao = (DepartmentDao) context.getBean("departmentDao");
		for(DepartmentVO dp : dao.selectAllDepartment()) {
			System.out.println(dp.toString());
		}
	}
}
