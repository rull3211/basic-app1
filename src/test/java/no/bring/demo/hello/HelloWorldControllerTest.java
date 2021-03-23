package no.bring.demo.hello;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ExtendedModelMap;

import static junit.framework.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HelloWorldControllerTest {

    @Mock
    private HelloWorldService helloWorldService;
    private HelloWorldController controller;
    private ExtendedModelMap model;

    @Before
    public void setUp() {
        initMocks(this);
        controller = new HelloWorldController(helloWorldService);
        model = new ExtendedModelMap();
    }

    @Test
    public void shouldSendHelloWorldMessageToProcessing() {
        String name = "Peter Pan";
        String expectedResponse = "Hello " + name;
        when(helloWorldService.getMessageForName(name)).thenReturn(expectedResponse);

        String view = controller.sayHelloWorld(name, model);

        assertThat(view).isEqualTo("helloWorld");
        assertThat(model.get("message")).isEqualTo(expectedResponse);
    }

    @Test
    public void shouldEchoName() {
        String name = "Peter Pan";

        controller.sayHelloWorld(name, model);

        assertEquals(name, model.get("name"));
    }

}
