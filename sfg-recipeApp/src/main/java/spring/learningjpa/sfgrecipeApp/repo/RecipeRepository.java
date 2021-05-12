package spring.learningjpa.sfgrecipeApp.repo;

import org.springframework.data.repository.CrudRepository;

import spring.learningjpa.sfgrecipeApp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
