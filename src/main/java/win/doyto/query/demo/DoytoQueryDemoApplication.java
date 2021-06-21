package win.doyto.query.demo;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import win.doyto.query.web.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = {"win.doyto.query.demo", "win.doyto.query.web.component"})
public class DoytoQueryDemoApplication  extends WebMvcConfigurerAdapter {

    @Generated
    public static void main(String[] args) {
		SpringApplication.run(DoytoQueryDemoApplication.class, args);
	}

}
