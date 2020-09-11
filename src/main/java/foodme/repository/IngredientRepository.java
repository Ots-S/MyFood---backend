package foodme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import foodme.entity.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	
	@Query(value = "SELECT * FROM Ingredient u where u.name = LOWER(:name) LIMIT 1", nativeQuery = true)
	Optional<Ingredient> findByName(@Param("name") String name);
	
}
