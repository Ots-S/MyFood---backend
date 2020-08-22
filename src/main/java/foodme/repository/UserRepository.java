package foodme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodme.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

