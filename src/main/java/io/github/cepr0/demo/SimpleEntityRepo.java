package io.github.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SimpleEntityRepo extends JpaRepository<SimpleEntity, Integer> {
	
	@Query(value = "select se.id as id from simple_entity se where se.id = ?1", nativeQuery = true)
	Optional<SimpleEntityDto> getDto(Integer id);
	
	Optional<SimpleEntityDto> getDtoById(Integer id);
	
}
