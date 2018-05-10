package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.domain.Category;
public interface CategoryRepository extends JpaRepository<Category, String> {
	 List<Category> findByName(String name);

}
