package com.example.jpatuts.jpatuts;

import com.example.jpatuts.jpatuts.entities.ProductEntity;
import com.example.jpatuts.jpatuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpatutsApplicationTests {
@Autowired
	ProductRepository productRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
	ProductEntity productEntity=ProductEntity.builder()
			.sku("nestle234")
			.title("Nestle Chocolate")
			.price(BigDecimal.valueOf(123.345))
			.quantity(13)
			.build();

	ProductEntity savedProductEntity=productRepository.save(productEntity);
		System.out.println(savedProductEntity);

	}

	@Test
	void getRepository(){
		List<ProductEntity> entities=productRepository.findByCreatedAtAfter(
				LocalDateTime.of(2024,1,1,0,0,0));
		System.out.println(entities);
	}
@Test
	void getRepositoryByTitle(){
		List<ProductEntity> entities=productRepository.findByTitle("ParleGBiscuit");
		System.out.println(entities);
	}
@Test
	void findByTitleAndPrice(){

		Optional<ProductEntity> entities=productRepository.findByTitleAndPrice("MirindaDrink", BigDecimal.valueOf(14.7));
	}

}
