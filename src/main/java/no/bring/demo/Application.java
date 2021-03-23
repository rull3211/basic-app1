package no.bring.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(PrisEntity.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PrisReopsitory repo ){
        return (args) ->{
            repo.save(new PrisEntity(50, 10, 5));

            for(PrisEntity e : repo.findAll()){
                log.info(e.toString());
            }
        };
    }
}