package com.skiresort.services;

import com.skiresort.db.PriceRepository;
import com.skiresort.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {
  @Autowired
  private PriceRepository priceRepository;

  public Optional<Price> getPriceById(int passId) {
    return priceRepository.findById(passId);
  }

  public void createNewPrice(Price price) {
    // check for errors before saving it


    priceRepository.save(price);
  }

  public List<Price> getPricesForCurrentSeason() {
    LocalDate now = LocalDate.now();
    int seasonYear = now.getYear();

    if (now.getMonthValue() < 5) {
      seasonYear++;
    }

    return priceRepository.findForCurrentSeason(seasonYear);
  }
}
