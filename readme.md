Native query method with **projection** (interface-based or class-based) containing **UUID** properties throws an exception:

> org.hibernate.MappingException: No Dialect mapping for JDBC type: 1111 

(tested on **PostgreSQL**)

Example:

```java
@Entity
public class Model {

	@Id
	@Column(columnDefinition = "uuid")
	private UUID id;

	@Column(columnDefinition = "uuid")
	private UUID objectId;

	private String name;
}

@Query(value = "" +
        "select " +
        "  m.id as id, " +
        "  m.object_id as objectId, " +
        "  m.name as name " +
        "from " +
        "  model m " +
        "where" +
        "  m.id = ?1", nativeQuery = true)
Optional<ModelProjection> getModelProjection(UUID id);
```

Native query with entity class works as expected.

How to reproduce:

1. Create database `uuid-demo` in PostgreSQL server (with username and password `postgres`, see 'application.properties')
2. Run test `io.github.cepr0.demo.ModelRepoTest` 