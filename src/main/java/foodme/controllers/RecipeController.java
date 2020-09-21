package foodme.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import foodme.entity.Ingredient;
import foodme.entity.Recipe;
import foodme.repository.IngredientRepository;
import foodme.repository.RecipeRepository;

@RestController
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowire
	private IngredientRepository ingredientRepository;
	
	@GetMapping("/recipes")
	public List<Recipe> getRecipes() {
		return recipeRepository.findAll();
	}
	
	@GetMapping("/recipe/{id}")
	public Optional<Recipe> getRecipe(@PathVariable Long id) {
		Optional<Recipe> recipe = recipeRepository.findById(id);
		return recipe;
	}
	
	@PostMapping("/recipe") 
	public ResponseEntity saveRecipe(@RequestBody Recipe recipe) {
		Optional<Recipe> newRecipe = recipeRepository.findByName(recipe.getName().toLowerCase());
		if (newRecipe.isPresent()) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		} else  {
		recipeRepository.save(recipe);
		return new ResponseEntity(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/recipes/{id}")
	public String deleteRecipe(@PathVariable Long id) {
		recipeRepository.deleteById(id);
		return "Recette supprimée";
	}
	
	@DeleteMapping("/recipes/{recipeId}/ingredient/{ingredientId}")
	public ResponseEntity deleteIngredientFromRecipe(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
		Optional<Recipe> recipe = recipeRepository.findById(recipeId);
		Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
		recipe.get().getIngredients().remove(ingredient.get());
		
	}
	
}
