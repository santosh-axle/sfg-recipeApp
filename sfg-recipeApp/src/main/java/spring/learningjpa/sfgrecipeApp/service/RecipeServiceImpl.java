package spring.learningjpa.sfgrecipeApp.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import spring.learningjpa.sfgrecipeApp.domain.Recipe;
import spring.learningjpa.sfgrecipeApp.repo.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	@Override
	public Set<Recipe> getRecipe() {
		Set<Recipe> recipe = new HashSet<Recipe>();
		recipeRepository.findAll().iterator().forEachRemaining(recipe::add);
		return recipe;
	}

}
