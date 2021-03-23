package no.bring.demo.hello;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldServiceTest {

	private HelloWorldService service;
	
	@Before
	public void setUp() {
		service = new HelloWorldService();
	}

	@Test
	public void shouldPrependHelloToName() {
		String name = "Peter Pan";

		String message = service.getMessageForName(name);
		
		assertThat(message).isEqualTo("Hello " + name);
	}
	
}
