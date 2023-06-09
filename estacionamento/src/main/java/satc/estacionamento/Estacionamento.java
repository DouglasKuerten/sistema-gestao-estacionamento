package satc.estacionamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author gusta
 */
@SpringBootApplication
@EnableWebMvc
@Configuration
public class Estacionamento {

    public static void main(String[] args) {
        SpringApplication.run(Estacionamento.class, args);
    }
}
