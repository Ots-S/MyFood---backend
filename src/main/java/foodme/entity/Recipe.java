package foodme.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(name = "recipe_ingredient", joinColumns = @JoinColumn(name = "recipe_id"), 
	inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredients = new ArrayList<>();
	
	public Recipe() {}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}
	
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
