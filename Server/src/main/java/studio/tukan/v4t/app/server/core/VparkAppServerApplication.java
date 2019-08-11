package studio.tukan.v4t.app.server.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class VparkAppServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VparkAppServerApplication.class, args);
	}

}
