package repository;

import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.DepartmentMapper;
import vo.DepartmentVO;

@Component
public class DepartmentDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public List<DepartmentVO> selectAllDepartment(){
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		return mapper.selectAllDepartment();
	}
}
