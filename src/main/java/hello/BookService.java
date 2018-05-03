package hello;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public Book getBook(String id)
	{
		return jdbcTemplate.queryForObject("select * from book where id=?",new Object[] {id}, new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int row) throws SQLException {
				Book book=new Book();
				book.setId(rs.getString("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setDes(rs.getString("des"));
				book.setImage(rs.getString("image"));
				return book;
			}
			
		});
	}
	@Transactional
	public void updatePrice(String id)
	{
		Book book=getBook(id);
		if(book.getPrice()>=10)
		{
			jdbcTemplate.update("update book set price=100 where id=?", id);
			throw new RuntimeException();
		}
	}
}
