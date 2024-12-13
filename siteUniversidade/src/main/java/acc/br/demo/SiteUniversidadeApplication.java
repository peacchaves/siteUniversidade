package acc.br.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SiteUniversidadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiteUniversidadeApplication.class, args);
    }
}