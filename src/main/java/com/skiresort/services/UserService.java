package com.skiresort.services;

import com.skiresort.db.UserRepository;
import com.skiresort.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public Optional<User> getUserById(String username) {
    return userRepository.findByUsername(username);
  }

  public void createNewUser(User user) {
    user.setJoinDate(LocalDate.now());
    userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
