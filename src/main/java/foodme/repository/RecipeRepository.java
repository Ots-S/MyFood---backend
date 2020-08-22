package foodme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodme.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
