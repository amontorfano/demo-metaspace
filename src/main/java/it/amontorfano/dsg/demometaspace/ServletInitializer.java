package it.amontorfano.dsg.demometaspace;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.docusign.esign.client.ApiClient;



@SpringBootApplication
public class ServletInitializer extends SpringBootServletInitializer {

	@Autowired
    private ConfigurableApplicationContext ctx;
	
	@Autowired
	ApiClient apiClient;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServletInitializer.class);
	}

	@PreDestroy 
	public void close() {
		System.err.println("Close application");

		
		
		var bf = ctx.getBeanFactory();
		if (bf != null) {
			System.err.println("clear metadata cache");
			bf.clearMetadataCache();
		}
		ctx.close();
		
	}
	
}
