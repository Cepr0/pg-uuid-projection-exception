package io.github.cepr0.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.UUID;

@Slf4j
@SpringBootApplication
public class Application {
	
	private final ModelRepo repo;
	
	public Application(ModelRepo repo) {
		this.repo = repo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@EventListener
	public void onReady(ApplicationReadyEvent e) {
		UUID id = repo.save(new Model()).getId();
		System.out.println(repo.getModel(id));
	}
}
