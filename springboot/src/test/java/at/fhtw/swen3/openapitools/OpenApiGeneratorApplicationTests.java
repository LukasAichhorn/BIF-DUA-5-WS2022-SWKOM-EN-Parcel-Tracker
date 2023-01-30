package at.fhtw.swen3.openapitools;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class OpenApiGeneratorApplicationTests {

    @Test
    void contextLoads() {
    }

}