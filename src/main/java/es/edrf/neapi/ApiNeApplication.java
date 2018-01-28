package es.edrf.neapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiNeApplication {

	// Instancia de la clase encargada de encriptar las passwords. 
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	public static void main(String[] args) {
		SpringApplication.run(ApiNeApplication.class, args);
	}
}
