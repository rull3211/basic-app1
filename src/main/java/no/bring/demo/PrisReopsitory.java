package no.bring.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrisReopsitory extends CrudRepository<PrisEntity, Long> {

    PrisEntity findById(long id);

    List<PrisEntity> findAll();
}
