package foodme.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cookbook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(name = "recipe_cookbook", joinColumns = @JoinColumn(name = "cookbook_id"), inverseJoinColumns = @JoinColumn(name = "recipe_id"))
	private List<Recipe> recipes = new ArrayList<>();
	
	public Cookbook() {}
	
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
	
	public List<Recipe> getRecipes() {
		return this.recipes;
	}
	
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
}
