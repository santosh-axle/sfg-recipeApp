package spring.learningjpa.sfgrecipeApp.repo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import spring.learningjpa.sfgrecipeApp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	Optional<Category> findByDescription(String desription);
}
