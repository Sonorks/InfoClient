package pearls.com.infoclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = "pearls.com")
@EnableAutoConfiguration
@EnableJpaRepositories("pearls.com.infrastructure.jpa")
@EntityScan("pearls.com.infrastructure.jpa")
public class InfoclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoclientApplication.class, args);
	}

}
