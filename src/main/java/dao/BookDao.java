package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Book;


@Service
public class BookDao {
	private final class BookRowMapper implements RowMapper<Book> {
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
	}
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Transactional
	public Boolean add(final Book book)  {
		int row=jdbcTemplate.update("insert into book(id,name,price,des,image) values(?,?,?,?,?)",
				book.id, book.name, book.price, book.des, book.image);
		return row>0;
	}

	public Book get(final String id)  {
		return jdbcTemplate.queryForObject("select * from book where id=?",new Object[] {id}, new BookRowMapper());

	}

	public List<Book> getAll()  {
		return jdbcTemplate.query("select * from book", new BookRowMapper());
	}


	public Boolean update(final Book book, final String oldId)  {
		int row=jdbcTemplate.update("update book set id=?,name=?,price=?,des=?,image=? where id=?",
				book.id,book.name,book.price, book.des, book.image, oldId);
		return row>0;
	}

	
	public Boolean delete(final String id) {
		int row=jdbcTemplate.update("delete from book where id=?",id);
		return row>0;
	}

}
