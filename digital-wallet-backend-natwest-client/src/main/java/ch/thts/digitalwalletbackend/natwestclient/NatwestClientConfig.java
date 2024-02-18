package ch.thts.digitalwalletbackend.natwestclient;

import ch.thts.digitalwalletbackend.natwestclient.account.NatWestAccountRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@ComponentScan
public class NatwestClientConfig {
    private final String url;

    public NatwestClientConfig(@Value("${natwest.client.url}") final String url) {
        this.url = url;
    }

    @Bean
    public NatWestAccountRestClient natWestAccountRestClient() {
        final HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(RestClient.create(url)))
                .build();
        return httpServiceProxyFactory.createClient(NatWestAccountRestClient.class);
    }

}
