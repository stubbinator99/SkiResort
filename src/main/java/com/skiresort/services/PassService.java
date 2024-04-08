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

  /*private PassWithPrice extractResults(Object[] results) {
    Pass pass = (Pass) results[0];
    Price price = (Price) results[1];

    return new PassWithPrice(pass, price);
  }*/

  public List<Pass> getAllPassesForUser(String username) {
    return passRepository.findPassesWithPricesForUsername(username);
  }

  public void createNewPass(Pass pass) {
    // check for errors before saving it

    passRepository.save(pass);
  }

  public Optional<Pass> getSoonestPassForUser(String username) {
    return passRepository.findSoonestPassForUser(username);
  }

  public List<Pass> getAllPasses() {
    return passRepository.findAll();
  }

  /*public Optional<PassWithPrice> getPassById(String passId) {
    Optional<Pass> passOpt = passRepository.findPassById(passId);
    if (passOpt.isEmpty()) {
      return Optional.empty();
    }
    return createPassWithPrice(passOpt.get());
  }*/

  /*private Optional<PassWithPrice> createPassWithPrice(Pass pass) {
    Optional<Price> priceOpt = priceRepository.findById(pass.getPriceId());
    if (priceOpt.isEmpty()) {
      return Optional.empty();
    }

    Price price = priceOpt.get();
    PassWithPrice pwp = PassMapper.mapToPassWithPrice(pass, price);
    return Optional.of(pwp);
  }*/

  /*public List<PassWithPrice> getAllPassesForUser(String username) {
    List<Pass> passes = passRepository.findPassesForUser(username);
    if (passes.isEmpty()) {
      return Collections.emptyList();
    }

    List<PassWithPrice> createdPasses = new ArrayList<>();
    for (Pass pass : passes) {
      Optional<PassWithPrice> pwp = createPassWithPrice(pass);
      pwp.ifPresent(createdPasses::add);
    }

    return createdPasses;
  }*/
}
