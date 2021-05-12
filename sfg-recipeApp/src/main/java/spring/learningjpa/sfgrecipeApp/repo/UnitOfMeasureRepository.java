package spring.learningjpa.sfgrecipeApp.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import spring.learningjpa.sfgrecipeApp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	
	Optional<UnitOfMeasure> findByUom(String uom);
}
