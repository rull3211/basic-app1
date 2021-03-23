package no.bring.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping(value="/hello")
    public String createPage() {
        return "helloWorld";
    }

    @PostMapping(value="/hello")
    public String sayHelloWorld(@RequestParam("name") String name, Model model) {
        String message = helloWorldService.getMessageForName(name);

        model.addAttribute("message", message);
        model.addAttribute("name", name);

        return "helloWorld";
    }
}

    
    
