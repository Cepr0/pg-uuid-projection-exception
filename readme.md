Native query method with **projection** (interface-based or class-based) containing **UUID** properties throws an exception:

> org.hibernate.MappingException: No Dialect mapping for JDBC type: 1111 

(tested on **PostgreSQL**)

Example:

```java
@Entity
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private UUID uuid;
}

@Query(value = "select m.id as id, m.uuid as uuid from model m where m.id = ?1", nativeQuery = true)
Optional<ModelProjection> getModelProjection(UUID id);
```

Native query with entity class works as expected.

How to reproduce:

1. Create database `uuid-demo` in PostgreSQL server (with username and password `postgres` - see 'application.properties')
2. Run test `io.github.cepr0.demo.ModelRepoTest` 