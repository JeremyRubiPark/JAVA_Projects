package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import vo.Department;

@Repository
public class QueryDao extends JdbcDaoSupport{
	@Autowired
	public QueryDao(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<String> getDeptNames(){
		String sql = "SELECT D.DEPTNAME FROM DEPARTMENT D";
		
		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
		
		return list;
	}
	
	public List<String> getDeptNames(String searchName){
		String sql = "SELECT D.DEPTNAME FROM DEPARTMENT D"+
						" WHERE D.DEPTNAME LIKE ?";
		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class,
				"%" + searchName + "%");
		return list;
	}
	
	public List<Department> getAllDept(){
		String sql = "SELECT D.DEPTID, D.DEPTNO, D.DEPTNAME FROM DEPARTMENT D";
		List<Department> dp = new ArrayList<>();
		List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql);
		for (Map<String, Object> d : list) {
			Department dpp = new Department();
			dpp.setDeptId((Integer) d.get("deptId"));
			dpp.setDeptNo((String) d.get("deptNo"));
			dpp.setDeptName((String) d.get("deptName"));
			dp.add(dpp);
		}
		return dp;
	}
}
