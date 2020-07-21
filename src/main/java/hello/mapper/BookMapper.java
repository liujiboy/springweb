package hello.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import hello.domain.Book;
import hello.domain.BookCategory;

@Mapper
public interface BookMapper {
	
	Book getBookById(Long id);
	
	@Insert("insert into books values(#{id},#{info},#{name},#{categoryId})")
	int insertBook(Book book);
	//book_category是创建的视图
	@Select("select * from book_category")
	List<BookCategory> getBookCategory();
}
