package test;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cfg.AppJdbcCfg;
import dao.QueryDao;
import vo.Department;

public class QueryForListTest{

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(AppJdbcCfg.class);
		QueryDao dao = context.getBean(QueryDao.class);
		List<Department> names = dao.getAllDept();
		for(Department name : names) {
			System.out.println(name.toString());
		}
		
	}

}
