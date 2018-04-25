Native query method with **UUID** and **projection** on **PostgreSQL** throws exception:
> org.hibernate.MappingException: No Dialect mapping for JDBC type: 1111 

Example:

```java
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

1. Create database uuid-demo
2. Run test `io.github.cepr0.demo.ModelRepoTest` 