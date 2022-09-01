package win.doyto.query.demo;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
public class NPlusOneApplication {

    @Generated
    public static void main(String[] args) {
        SpringApplication.run(NPlusOneApplication.class, args);
    }

}
