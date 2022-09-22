package it.amontorfano.dsg.demometaspace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.docusign.esign.client.ApiClient;

@Configuration
public class MyConfiguration {

	@Bean
	ApiClient apiClient() {
		return new ApiClient();
	}
	
}
