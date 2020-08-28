package foodme.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}	
