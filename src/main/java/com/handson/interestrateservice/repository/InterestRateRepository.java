package com.handson.interestrateservice.repository;

import com.handson.interestrateservice.model.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestRateRepository  extends JpaRepository<InterestRate, Long> {

    Optional<InterestRate> findByTitleContaining(String title);
}
