package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Category;
import app.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value="/getCategory.do")
	public Category getCategory(String id)
	{
		return categoryService.getCategory(id);
	}
	@RequestMapping(value="/findCategory.do")
	public List<Category> findCategory(String name)
	{
		return categoryService.findCategory(name);
	}
}
