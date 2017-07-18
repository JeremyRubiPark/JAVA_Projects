package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.FileMapper;
import vo.FileInfoVO;

@Component
public class FileDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate){
		this.sessionTemplate = sessionTemplate;
	}
	
	public int insert(FileInfoVO fileInfoVO){
		FileMapper mapper = sessionTemplate.getMapper(FileMapper.class);
		return mapper.insert(fileInfoVO);
	}
	
	public FileInfoVO select(int fileNum){
		FileMapper mapper = sessionTemplate.getMapper(FileMapper.class);
		return mapper.select(fileNum);
	}
	
	public List<FileInfoVO> selectAll(){
		FileMapper mapper = sessionTemplate.getMapper(FileMapper.class);
		return mapper.selectAll();
	}
}
