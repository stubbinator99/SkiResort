package com.skiresort.services;

import com.skiresort.db.PassRepository;
import com.skiresort.models.Pass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassService {
  @Autowired
  private PassRepository passRepository;

  public Optional<Pass> getPassById(String passId) {
    return passRepository.findPassById(passId);
  }

  public void createNewPass(Pass pass) {
    // check for errors before saving it


    passRepository.save(pass);
  }

  public List<Pass> getAllPassesForUser(String username) {
    return passRepository.findPassesForUser(username);
  }

  public Optional<Pass> getSoonestPassForUser(String username) {
    return passRepository.findSoonestPassForUser(username);
  }
}
