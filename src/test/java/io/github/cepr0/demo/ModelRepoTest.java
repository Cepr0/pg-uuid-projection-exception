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
public class ModelRepoTest {

	@Autowired private ModelRepo modelRepo;

	private Model model;

	@Before
	public void setUp() {
		model = modelRepo.save(new Model());
	}

	@Test
	public void getModel() {
		assertThat(modelRepo.getModel(model.getId()).get()).isNotNull();
	}

	@Test
	public void getModelProjection() {
		assertThat(modelRepo.getModelProjection(model.getId()).get()).isNotNull();
	}
	
	@Test
	public void getModelDto() {
		assertThat(modelRepo.getModelDto(model.getId()).get()).isNotNull();
	}
}