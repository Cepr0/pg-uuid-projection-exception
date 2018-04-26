Native query method with **projection** containing **UUID** properties throws an exception:

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

To workaround this I created a custom PostgreSQL dialect class:

```java
public class CustomPostgreSQL95Dialect extends PostgreSQL95Dialect {
	
	public PatchedPostgreSQL95Dialect() {
		super();
		registerHibernateType(Types.OTHER, "org.hibernate.type.PostgresUUIDType");
	}
}
``` 

And set it in the 'application.properties'

`spring.jpa.properties.hibernate.dialect=io.github.cepr0.demo.CustomPostgreSQL95Dialect`

P.S. During testing, it turned out that [class-based projections](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections.dtos) 
does not work with native queries - they throw an exception:

```
org.springframework.core.convert.ConverterNotFoundException: 
No converter found capable of converting from type [org.springframework.data.jpa.repository.query.AbstractJpaQuery$TupleConverter$TupleBackedMap] 
to type [io.github.cepr0.demo.ModelDto]
```