package com.example.demo;

import com.example.demo.model.Flurb;
import com.example.demo.model.Foo;
import com.example.demo.model.FooRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.function.RouterFunction;

import static org.springframework.web.servlet.function.RequestPredicates.*;
import static org.springframework.web.servlet.function.RouterFunctions.*;
import static org.springframework.web.servlet.function.ServerResponse.*;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "fixedAuditor")
@EnableJpaRepositories(basePackageClasses = FooRepository.class)
@RequiredArgsConstructor
public class SpringNativeJpaDemoApplication {
	private final FooRepository entities;

	@Bean
	public CommandLineRunner runner() {
		return args -> {

			Optional<Foo> maybeFoo = entities.findById(1L);
			Foo foo;
			foo = maybeFoo.orElseGet(() -> entities.save(new Foo("Hello")));
			Flurb flurb = new Flurb();
			flurb.setValue("Balla balla");
			foo.setFlurb(flurb);
			entities.save(foo);

			entities.findWithBetween("a", "X");
		};
	}

	@Bean
	AuditorAware<String> fixedAuditor() {
		return () -> Optional.of("Douglas Adams");
	}

	@Bean
	public RouterFunction<?> userEndpoints() {
		return route(GET("/"), request -> ok().body(findOne()));
	}

	private Foo findOne() {
		return entities.findById(1L).get();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringNativeJpaDemoApplication.class, args);
	}
}
