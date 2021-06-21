package win.doyto.query.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DoytoQueryDemoApplicationTests {

	@Autowired
	protected MockMvc mockMvc;


	@Test
	void contextLoads() {
	}

}
