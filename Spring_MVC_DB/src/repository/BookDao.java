package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.BookMapper;
import vo.BookVO;

@Component
public class BookDao {
	@Autowired
	private SqlSessionTemplate session;
    
    public void setSession(SqlSessionTemplate session) {
        this.session = session;
    }
/////////////////////////////////////////////////////////////////
    public int insertBook(BookVO book){
        BookMapper mapper = session.getMapper(BookMapper.class);
        return mapper.insert(book);
    }
     
    public BookVO selectBook(int bookNum){
        BookMapper mapper = session.getMapper(BookMapper.class);
        return mapper.selectOne(bookNum);
    }
     
    public List<BookVO> selectBookListAll(){
        BookMapper mapper = session.getMapper(BookMapper.class);
        return mapper.selectAll();
    }
    
    public int updateBook(BookVO book){
    	BookMapper mapper = session.getMapper(BookMapper.class);
    	return mapper.update(book);
    }
    public int deleteBook(BookVO book){
    	BookMapper mapper = session.getMapper(BookMapper.class);
    	return mapper.delete(book);
    }
}
