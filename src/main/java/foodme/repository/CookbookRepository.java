package foodme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodme.entity.Cookbook;

@Repository
public interface CookbookRepository extends JpaRepository<Cookbook, Long> {

}
