package io.github.cepr0.demo;

import org.hibernate.dialect.PostgreSQL95Dialect;

import java.sql.Types;

public class CustomPostgreSQL95Dialect extends PostgreSQL95Dialect {
	
	public CustomPostgreSQL95Dialect() {
		super();
		registerHibernateType(Types.OTHER, "org.hibernate.type.PostgresUUIDType");
	}
}
