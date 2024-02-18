package ch.thts.digitalwalletbackend.app;

import ch.thts.digitalwalletbackend.business.BusinessConfig;
import ch.thts.digitalwalletbackend.natwestclient.NatwestClientConfig;
import ch.thts.digitalwalletbackend.restapi.RestApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(value = {
        BusinessConfig.class,
        NatwestClientConfig.class,
        RestApiConfig.class
})
@SpringBootApplication
public class DigitalWalletBackendApplication {

    public static void main(final String[] args) {
        SpringApplication.run(DigitalWalletBackendApplication.class, args);
    }
}
