package dev.rost.aspects.ez;

import org.springframework.stereotype.Service;

@Service
public class EzService {

    @Ez(forWhom = "SOLO ${stavki}")
    public void ezMove() {
        System.out.println("EzService#ezMove");
    }
}
