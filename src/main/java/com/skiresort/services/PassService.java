package com.skiresort.services;

import com.skiresort.db.PassRepository;
import com.skiresort.models.Pass;
import com.skiresort.models.PassWithPrice;
import com.skiresort.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassService {
  @Autowired
  private PassRepository passRepository;

  public Optional<PassWithPrice> getPassWithPriceById(String passId) {
    Object[] results = passRepository.findPassWithPriceById(passId);
    if (results.length == 0) {
      return Optional.empty();
    }

    return Optional.of(extractResults(results));
  }

  private PassWithPrice extractResults(Object[] results) {
    Pass pass = (Pass) results[0];
    Price price = (Price) results[1];

    return new PassWithPrice(pass, price);
  }

  public List<PassWithPrice> getAllPassesForUser(String username) {
    List<PassWithPrice> passes = new ArrayList<>();
    List<Object[]> results = passRepository.findPassesWithPricesForUsername(username);
    for (Object[] result : results) {
      PassWithPrice pass = extractResults(result);
      passes.add(pass);
    }

    return passes;
  }

  public void createNewPass(Pass pass) {
    // check for errors before saving it

    passRepository.save(pass);
  }

  public Optional<PassWithPrice> getSoonestPassForUser(String username) {
    Optional<Object[]> recordOpt = passRepository.findSoonestPassForUser(username);
    if (recordOpt.isEmpty()) {
      return Optional.empty();
    }

    Object[] record = recordOpt.get();
    Pass pass = (Pass) record[0];
    Price price = (Price) record[1];
    PassWithPrice pwp = new PassWithPrice(pass, price);
    return Optional.of(pwp);
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
