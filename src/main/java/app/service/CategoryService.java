package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.domain.Category;
import app.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository rep;
	
	@Transactional
	public void addCategory(String id,String name)
	{
		Category c=new Category();
		c.setId(id);
		c.setName(name);
		rep.save(c);
	}
	@Transactional
	public void initCategories()
	{
		if(!rep.existsById("001"))
		{
			addCategory("001","文学");
		}
		if(!rep.existsById("002"))
		{
			addCategory("002","历史");
		}
		if(!rep.existsById("003"))
		{
			addCategory("003","技术");
		}
	}

	public Category getCategory(String id) {
		
		return rep.findById(id).get();
	}

	public List<Category> findCategory(String name) {
		return rep.findByName(name);
	}
}
