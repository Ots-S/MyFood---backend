package foodme.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import foodme.entity.Cookbook;
import foodme.repository.CookbookRepository;

@RestController
public class CookbookController {
	
	@Autowired
	private CookbookRepository cookbookRepository;
	
	@GetMapping("/cookbooks")
	public List<Cookbook> getCookbooks() {
		return cookbookRepository.findAll();
	}
	
	@PostMapping("/cookbooks")
	public ResponseEntity createCookbook(@RequestBody Cookbook cookbook) {
		Optional<Cookbook> newCookbook = cookbookRepository.findByName(cookbook.getName());
		if(newCookbook.isPresent()) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		} else {
			cookbookRepository.save(cookbook);
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}
	}
	
	@DeleteMapping("/cookbooks/{id}")
	public ResponseEntity deleteCookbook(@PathVariable Long id) {
		cookbookRepository.deleteById(id);
		Optional<Cookbook> deletedCookbook = cookbookRepository.findById(id);
		if(deletedCookbook.isPresent()) {
			return new ResponseEntity(HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}
	}
}	
