package no.bring.demo;

import no.bring.demo.model.PrisEntity;
import no.bring.demo.repository.PrisReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Autowired // bruker CommandLineRunner for å lagre prisentiteten i h2-inMemory databasen
    PrisReopsitory repo;

    public void run(String... args) throws Exception{
        repo.save(new PrisEntity(50, 10, 5));
    }
}