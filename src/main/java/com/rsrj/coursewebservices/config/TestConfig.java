package com.rsrj.coursewebservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rsrj.coursewebservices.entities.Order;
import com.rsrj.coursewebservices.entities.User;
import com.rsrj.coursewebservices.repositories.OrderRepository;
import com.rsrj.coursewebservices.repositories.UserRepository;

/* Para fazer a configuração no perfil de teste fazendo o data seeding, ou seja,
 * populando o banco de dados de teste com novos dados*/

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	/*CommandLineRunner é a forma de fazer a classe ser executada no inicio da aplicação*/
	
	/*Injecao de dependencias*/
	@Autowired
	 private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;	
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
		/*Horário no padrão ISO8601: YYYY-MM-DDTHH:MM:SSZ. O Z após a data refere-se ao horário GMT*/
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		/*Persistir os objetos*/
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
