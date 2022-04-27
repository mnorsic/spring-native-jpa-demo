package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
class SpringNativeJpaDemoApplicationTests {

	@Autowired
	private WebTestClient client;

	@Test
	void contextLoads() {
	}

	@Test
	public void test() {
		client.get().uri("/").exchange().expectBody(String.class).isEqualTo("{\"value\":\"Hello\",\"flurb\":{}}");
	}

}
