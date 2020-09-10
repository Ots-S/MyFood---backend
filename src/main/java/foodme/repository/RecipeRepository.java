package foodme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import foodme.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	@Query("SELECT u FROM Recipe u WHERE u.name = LOWER(:name)")
	Optional<Recipe> findByName(@Param("name") String name);
	
}
