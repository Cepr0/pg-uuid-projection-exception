package io.github.cepr0.demo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Data
@Entity
public class Model {

	@Id
	@Column(columnDefinition = "uuid")
	private UUID id;

	@Column(columnDefinition = "uuid")
	private UUID objectId;

	private String name;

	@PrePersist
	public void prePersist() {
		id = UUID.randomUUID();
		objectId = UUID.randomUUID();
		name = UUID.randomUUID().toString();
	}
}
