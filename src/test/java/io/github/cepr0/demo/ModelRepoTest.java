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
	public void setUp() throws Exception {
		model = modelRepo.save(new Model());
	}

	@Test
	public void getModel() {
		modelRepo.getModel(model.getId())
				.map(m -> {
					System.out.println(m.getId());
					return assertThat(m).isNotNull();
				}).orElseThrow(RuntimeException::new);
	}

	@Test
	public void getModelProjection() {
		modelRepo.getModelProjection(model.getId())
				.map(m -> {
					System.out.println(m.getId());
					return assertThat(m).isNotNull();
				}).orElseThrow(RuntimeException::new);
	}
}