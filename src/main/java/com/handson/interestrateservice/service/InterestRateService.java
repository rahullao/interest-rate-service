package com.handson.interestrateservice.service;

import com.handson.interestrateservice.model.InterestRate;
import com.handson.interestrateservice.repository.InterestRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InterestRateService {

    private final InterestRateRepository interestRateRepository;

    public List<InterestRate> getAllInterestRates() {
        return interestRateRepository.findAll();
    }

    public Optional<InterestRate> getInterestRateByTitle(final String title) {
        return interestRateRepository.findByTitleContaining(title);
    }
}
