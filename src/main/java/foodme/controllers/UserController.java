package foodme.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import foodme.entity.User;
import foodme.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.findById(id).get();
	}

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PostMapping("/user/{id}")
	public String updateUser(@PathVariable Long id, @RequestBody User user) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			userRepository.save(user);
			return "Sauvegardé";
		} else {
			return "Non sauvegardé";
		}
	}

	@DeleteMapping("/user/{id}")
	public @ResponseBody void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);

	}
}
