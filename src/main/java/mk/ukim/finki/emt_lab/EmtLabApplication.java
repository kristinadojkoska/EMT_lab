package mk.ukim.finki.emt_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EmtLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmtLabApplication.class, args);
    }

}
