package win.doyto.query.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"win.doyto.query.demo", "win.doyto.query.web.component"})
public class DoytoQueryDemoApplication {

    public static void main(String[] args) {
		SpringApplication.run(DoytoQueryDemoApplication.class, args);
	}

}
