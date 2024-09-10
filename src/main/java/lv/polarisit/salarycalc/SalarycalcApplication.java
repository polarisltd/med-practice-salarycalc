
package lv.polarisit.salarycalc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SalarycalcApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SalarycalcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SalarycalcApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		logger.info("Swagger UI available at: http://localhost:8081/swagger-ui.html");
	}
}