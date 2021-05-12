package spring.learningjpa.sfgrecipeApp.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import spring.learningjpa.sfgrecipeApp.domain.Recipe;
import spring.learningjpa.sfgrecipeApp.domain.UnitOfMeasure;
import spring.learningjpa.sfgrecipeApp.repo.CategoryRepository;
import spring.learningjpa.sfgrecipeApp.repo.RecipeRepository;
import spring.learningjpa.sfgrecipeApp.repo.UnitOfMeasureRepository;
import spring.learningjpa.sfgrecipeApp.domain.Category;
import spring.learningjpa.sfgrecipeApp.domain.Difficulty;
import spring.learningjpa.sfgrecipeApp.domain.Ingredient;
import spring.learningjpa.sfgrecipeApp.domain.Notes;

@Component
public class RecipeBootStrap implements ApplicationListener<ContextRefreshedEvent>{

	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final CategoryRepository categoryRepository;
	
	public RecipeBootStrap(RecipeRepository recipeRepository,
							UnitOfMeasureRepository unitOfMeasureRepository,	
							CategoryRepository categoryRepository) {
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.categoryRepository = categoryRepository;
	}
	
		
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("withIn Events Context");
		recipeRepository.saveAll(getRecipe());		
	}

	private List<Recipe> getRecipe() {
		List<Recipe> recipe= new ArrayList<>(2);
		
		Optional<UnitOfMeasure> eachUOMOptional = unitOfMeasureRepository.findByUom("Each");
		if(!eachUOMOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure Each not found");
		}
		
		Optional<UnitOfMeasure> cupUOMOptional = unitOfMeasureRepository.findByUom("Cup");
		if(!cupUOMOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure Cup not found");
		}
		
		Optional<UnitOfMeasure> tableSpoonUOMOptional = unitOfMeasureRepository.findByUom("tablespoon");
		if(!tableSpoonUOMOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure TableSpoon not found");
		}
		
		Optional<UnitOfMeasure> teaSpoonUOMOptional = unitOfMeasureRepository.findByUom("teaspoon");
		if(!teaSpoonUOMOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure Teaspoon not found");
		}
		
		Optional<UnitOfMeasure> dashUOMOptional = unitOfMeasureRepository.findByUom("Dash");
		if(!dashUOMOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure Dash not found");
		}
		
		Optional<UnitOfMeasure> pintUOMOptional = unitOfMeasureRepository.findByUom("Pint");
		if(!pintUOMOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure Pint not found");
		}
		
		UnitOfMeasure eachUOM 	= eachUOMOptional.get();
		UnitOfMeasure pintUOM	= pintUOMOptional.get();
		UnitOfMeasure dashUOM 	= dashUOMOptional.get();
		UnitOfMeasure teaSpoonUOM 	=teaSpoonUOMOptional.get();
		UnitOfMeasure tableSpoonUOM = tableSpoonUOMOptional.get();
		UnitOfMeasure cupUOM		= cupUOMOptional.get();
		
		
		Optional<Category> indianCategoryOptional = categoryRepository.findByDescription("INDIAN");
		if(!indianCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category INDIAN not found");
		}
		
		Optional<Category> jainCategoryOptional = categoryRepository.findByDescription("JAIN");
		if(!jainCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category JAIN not found");
		}
		
		Category indianCategory = indianCategoryOptional.get();
		Category jainCategory = jainCategoryOptional.get();
		
		Recipe guacRecipe = new Recipe();
		guacRecipe.setCookTime(10);
		guacRecipe.setPrepTime(15);
		guacRecipe.setDescription("Perfect Guacamole");
		guacRecipe.setDifficulty(Difficulty.EASY);
		guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");
		
		Notes guacNotes = new Notes();
		guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
		
		//guacNotes.setRecipe(guacRecipe);
		guacRecipe.setNotes(guacNotes);
		
		guacRecipe.getIngredient().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUOM, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("Kosher salt", new BigDecimal(".5"), pintUOM, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), cupUOM, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), teaSpoonUOM, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), tableSpoonUOM, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("Cilantro", new BigDecimal(2), tableSpoonUOM, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashUOM, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUOM, guacRecipe));
		
        guacRecipe.getCategories().add(indianCategory);
        guacRecipe.getCategories().add(jainCategory);
        System.out.println("Guac Recipe: "+guacRecipe.getDescription());
        recipe.add(guacRecipe);
        return recipe;
				
	}

}








































