package foodme.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import foodme.entity.Ingredient;
import foodme.repository.IngredientRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class IngredientController {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	

	@GetMapping("/ingredients") 
	public List<Ingredient> getIngredients() {
		return ingredientRepository.findAll();
	}
	
	@GetMapping("/ingredient/{id") 
	public Optional<Ingredient> getIngredient(@PathVariable Long id) {
		Optional<Ingredient> ingredient = ingredientRepository.findById(id);
		return ingredient;
	}
	
	@PostMapping("/ingredient")
	public ResponseEntity saveIngredient(@RequestBody Ingredient ingredient) {
		Optional<Ingredient> newIngredient = ingredientRepository.findByName(ingredient.getName());
		if (newIngredient.isPresent()) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		} else {
			ingredientRepository.save(ingredient);
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}
	}
	
	@DeleteMapping("/ingredient/{id}") 
	public String deleteIngredient(@PathVariable Long id) {
		ingredientRepository.deleteById(id);
		return "Supprimé";
	}
}
