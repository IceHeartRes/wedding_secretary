package wedding_secretary.temp.wedding_secretary;


import com.temp.wedding_secretary.configuration.RestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import wedding_secretary.temp.wedding_secretary.configiration.DatabaseConfiguration;

@Configuration
@ImportResource({"classpath:test-properties-context.xml"})
public class PropertiesConfig {
    @ContextConfiguration(classes = {
            PropertiesConfig.class,
            DatabaseConfiguration.class,
            RestConfiguration.class
    })

    public static class CommonContextConfigurationTest {
    }
}