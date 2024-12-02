package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
		User findByEmail(String email);

}
