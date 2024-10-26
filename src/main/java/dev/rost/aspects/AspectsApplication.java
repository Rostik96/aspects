package dev.rost.aspects;

import dev.rost.aspects.ez.EzService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectsApplication.class, args);
	}


	@Bean
	ApplicationListener<ApplicationReadyEvent> onStartup(EzService ezService) {
	    return event -> {
			ezService.ezMove();
		};
	}
}
