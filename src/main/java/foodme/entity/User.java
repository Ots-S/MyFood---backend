package foodme.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	
	@ManyToMany
	@JoinTable(name = "user_cookbook", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "cookbook_id"))
	private List<Cookbook> cookbooks = new ArrayList<>(); 
	
	@ManyToMany
	@JoinTable(name = "user_recipe", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "recipe_id"))
	private List<Recipe> recipes = new ArrayList<>();
	
	public User() {}
	
	public String getName() {
		return this.username;
	}
	
	public void setName(String name) {
		this.username = name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Recipe> getRecipes() {
		return this.recipes;
	}
	
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
}
