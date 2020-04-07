package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Book;


@Service
public class BookDao {
	@Autowired
	private JdbcTemplate jt;
	
	@Transactional
	public Boolean add(final Book book) throws Exception {
		int row=jt.update("insert into book(id,name,price,des,image) values(?,?,?,?,?)",
				book.id, book.name, book.price, book.des, book.image);
		return row>0;
	}

	
	public Book get(final String id) throws Exception {

		jt.queryfor
		List<Book> books=jt.query("select * from book where id=?", new Object[] {id},new ResultSetExtractor<Book>() {

			@Override
			public Book extractData(ResultSet rs) throws SQLException, DataAccessException {
				Book book = new Book();
				book.id = rs.getString("id");
				book.name = rs.getString("name");
				book.price = rs.getDouble("price");
				book.des = rs.getString("des");
				book.image = rs.getString("image");
				return book;
			}
		
		});
		return book;

	}

	// 获取全部
	@Query
	public List<Book> getAll() throws Exception {
		List<Book> books = new ArrayList<Book>();
		PreparedStatement ps = conn.prepareStatement("select * from book");
		ps.execute();
		ResultSet rs = ps.getResultSet();
		while (rs.next()) {
			Book book = new Book();
			book.id = rs.getString("id");
			book.name = rs.getString("name");
			book.price = rs.getDouble("price");
			book.des = rs.getString("des");
			book.image = rs.getString("image");
			books.add(book);
		}
		return books;

	}


	public Boolean update(final Book book, final String oldId) throws Exception {
		PreparedStatement ps = conn.prepareStatement("update book set id=?,name=?,price=?,des=?,image=? where id=?");
		ps.setString(1, book.id);
		ps.setString(2, book.name);
		ps.setDouble(3, book.price);
		ps.setString(4, book.des);
		ps.setString(5, book.image);
		ps.setString(6, oldId);
		ps.execute();
		return true;
	}

	
	public Boolean delete(final String id) throws Exception {
		PreparedStatement ps = conn.prepareStatement("delete from book where id=?");
		ps.setString(1, id);
		ps.execute();
		return true;
	}

}
