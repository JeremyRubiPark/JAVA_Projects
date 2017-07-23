package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vo.Department;

public class DepartmentRowMapper implements RowMapper<Department>{

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Department department = new Department();
		department.setDeptId(rs.getInt("DEPTID"));
		department.setDeptNo(rs.getString("DEPTNO"));
		department.setDeptName(rs.getString("DEPTNAME"));
		return department;
	}
}
