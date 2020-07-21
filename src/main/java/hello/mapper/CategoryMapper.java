package hello.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import hello.domain.Category;

@Mapper
public interface CategoryMapper {
	@Insert("insert into categories(id,name,code) values(#{id},#{name},#{code})")
	int insertCategory(Category category);
}
