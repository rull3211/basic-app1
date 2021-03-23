package no.bring.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;


@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(PrisEntity.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
    @Autowired
    PrisReopsitory repo;

    public void run(String... args) throws Exception{
        repo.save(new PrisEntity(50, 10, 5));
    }
}