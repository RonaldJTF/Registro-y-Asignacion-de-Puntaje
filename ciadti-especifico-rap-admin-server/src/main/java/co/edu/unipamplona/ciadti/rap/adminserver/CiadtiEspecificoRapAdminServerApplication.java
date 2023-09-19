package co.edu.unipamplona.ciadti.rap.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class CiadtiEspecificoRapAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiadtiEspecificoRapAdminServerApplication.class, args);
	}

}
