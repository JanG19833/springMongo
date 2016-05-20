package com.example.test.mongo;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {



	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		repository.save(new Customer("blub","Bla"));
		repository.save(new Customer("aaaaa","Blubb"));



		RestTemplate restTemplate = new RestTemplate();
		Customer recievdCustomer = restTemplate.getForObject("http://localhost:8081", Customer.class);
		System.out.println("Recvied data: "+recievdCustomer.toString());
		repository.save(new Customer(recievdCustomer.getFirstName(),recievdCustomer.getLastName()));
		repository.findAll().forEach(System.out::println);

	}
}
