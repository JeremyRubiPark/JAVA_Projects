package mapper;

import java.util.List;

import vo.BookVO;

public interface BookMapper {
    public int insert(BookVO book); // -> SQL 명령어 하나
    public BookVO selectOne(int bookNum); // -> SQL 명령어 하나
    public List<BookVO> selectAll();  // -> SQL 명령어 하나
    public int update(BookVO book);
    public int delete(BookVO book);
}
