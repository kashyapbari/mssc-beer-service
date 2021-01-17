package com.kashyapbari.msscbeerservice.bootstrap;

import com.kashyapbari.msscbeerservice.domain.Beer;
import com.kashyapbari.msscbeerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("Budwijheer")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(10)
                    .upc(1111111111L)
                    .price(new BigDecimal(100))
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("kingfiser")
                    .beerStyle("LAGER")
                    .quantityToBrew(200)
                    .minOnHand(10)
                    .upc(1111111112L)
                    .price(new BigDecimal(100))
                    .build());
        }
    }
}
