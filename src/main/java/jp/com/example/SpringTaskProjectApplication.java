package jp.com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jp.com.example.service.ProductService;

@SpringBootApplication
public class SpringTaskProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringTaskProjectApplication.class, args);

		ProductService productService = context.getBean(ProductService.class);

		System.out.println(productService.find());
	}

}
