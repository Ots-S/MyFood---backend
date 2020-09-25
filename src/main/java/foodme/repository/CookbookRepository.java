package foodme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import foodme.entity.Cookbook;

@Repository
public interface CookbookRepository extends JpaRepository<Cookbook, Long> {
	@Query(value = "SELECT * FROM Cookbook u WHERE u.name = :name LIMIT 1", nativeQuery = true)
	Optional<Cookbook> findByName(@Param("name") String name);
}
