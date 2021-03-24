package no.bring.demo.repository;

import no.bring.demo.model.PrisEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrisReopsitory extends CrudRepository<PrisEntity, Long> { //interface for crudrepo som oppretter databasen

    PrisEntity findById(long id);

    List<PrisEntity> findAll();
}
