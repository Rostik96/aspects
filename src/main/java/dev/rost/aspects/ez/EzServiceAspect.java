package dev.rost.aspects.ez;

import dev.rost.aspects.util.SpELResolver;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
class EzServiceAspect {

    private final SpELResolver spELResolver;


    @Before("@annotation(ez)")
    void ezMove(Ez ez) {
        System.out.println("@Before");
        System.out.println("ez.forWhom() = " + spELResolver.resolveStringValue(ez.forWhom()));
    }
}
