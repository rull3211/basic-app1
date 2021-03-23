package no.bring.demo.hello;

import org.springframework.stereotype.Service;

import static java.lang.String.join;

@Service
public class HelloWorldService {

    public String getMessageForName(String name) {
        return join(" ", "Hello", name);
    }

}
