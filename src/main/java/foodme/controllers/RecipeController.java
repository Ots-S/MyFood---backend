package foodme.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String saveRecipe(@RequestBody Recipe recipe) {
		recipeRepository.save(recipe);
		return "Sauvegardé";
	}
	
	@DeleteMapping("/recipes/{id}")
	public String deleteRecipe(@PathVariable Long id) {
		recipeRepository.deleteById(id);
		return "Recette supprimée";
	}
	
}
