package mk.finki.ukim.mk.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication

public class Labs1Application {

    public static void main(String[] args) {
        SpringApplication.run(Labs1Application.class, args);
    }

}
