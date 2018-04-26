package io.github.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ModelRepo extends JpaRepository<Model, UUID> {

	@Query(value = "" +
			"select " +
			"  m.id as id, " +
			"  m.uuid as uuid " +
			"from " +
			"  model m " +
			"where" +
			"  m.id = ?1", nativeQuery = true)
	Optional<Model> getModel(UUID id);

	@Query(value = "" +
			"select " +
			"  m.id as id, " +
			"  m.uuid as uuid " +
			"from " +
			"  model m " +
			"where" +
			"  m.id = ?1", nativeQuery = true)
	Optional<ModelProjection> getModelProjection(UUID id);
	
	@Query(value = "" +
			"select " +
			"  m.id as id, " +
			"  m.uuid as uuid " +
			"from " +
			"  model m " +
			"where" +
			"  m.id = ?1", nativeQuery = true)
	Optional<ModelDto> getModelDto(UUID id);
}
