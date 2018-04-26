package io.github.cepr0.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SimpleEntityRepoTest {
	
	@Autowired private SimpleEntityRepo repo;
	private SimpleEntity entity;
	
	@Before
	public void setUp() {
		entity = repo.save(new SimpleEntity());
	}
	
	@Test
	public void getDto() {
		assertThat(repo.getDto(entity.getId())).isNotEmpty();
	}
	
	@Test
	public void getDtoById() {
		assertThat(repo.getDtoById(entity.getId())).isNotEmpty();
	}
}