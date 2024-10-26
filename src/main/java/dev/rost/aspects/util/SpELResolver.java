package dev.rost.aspects.util;

import lombok.Setter;
import lombok.experimental.Delegate;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import java.util.Arrays;

@Component
public class SpELResolver implements EmbeddedValueResolverAware {

    @Setter
    @Delegate
    private StringValueResolver embeddedValueResolver;


    public String[] resolveStringValues(String... values) {
        return Arrays.stream(values)
                .map(embeddedValueResolver::resolveStringValue)
                .toArray(String[]::new);
    }
}
