package com.handson.interestrateservice.web;

import com.handson.interestrateservice.model.InterestRate;
import com.handson.interestrateservice.service.InterestRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class InterestRateController {

    private final InterestRateService interestRateService;

    @GetMapping("/interest-rates")
    public ResponseEntity<List<InterestRate>> getAllInterestRates() {
        List<InterestRate> interestRates = interestRateService.getAllInterestRates();
        if (interestRates.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(interestRates, HttpStatus.OK);
    }

    @GetMapping("/interest-rates/{title}")
    public ResponseEntity<InterestRate> getInterestRateByTitle(@PathVariable("title") final String title) {
        Optional<InterestRate> optional = interestRateService.getInterestRateByTitle(title);
        return optional.map(interestRate -> new ResponseEntity<>(interestRate, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
