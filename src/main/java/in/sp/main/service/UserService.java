package in.sp.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.sp.main.entity.User;


public interface UserService {
	public boolean registerUser(User user);
	public User loginUser(String email, String password);
	public List<User> getAllUsers();
}
