package sit.int221.coolcream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sit.int221.coolcream.services.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class})
public class CoolcreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoolcreamApplication.class, args);
	}

}
