/**
 * 
 */
package sk.jazzman.preschool.app;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author jano
 *
 */
@Component
@EnableAutoConfiguration
@ComponentScan
public class PreschoolApplication extends WebApplication {

	private static final Logger log = LoggerFactory.getLogger(PreschoolApplication.class);

	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PreschoolApplication.class, args);
	}

	@Override
	public Class<? extends Page> getHomePage() {

		return null;
	}

	@Override
	protected void init() {
		super.init();
		log.info("Initialize application");

		getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext));
		mountPages();
		log.info("Initialization done");
	}

	/**
	 * Mount pages
	 */
	protected void mountPages() {

	}
}
