package win.doyto.query.demo;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import win.doyto.query.web.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DoytoQueryDemoApplication extends WebMvcConfigurerAdapter {

    @Generated
    public static void main(String[] args) {
        SpringApplication.run(DoytoQueryDemoApplication.class, args);
    }

}
