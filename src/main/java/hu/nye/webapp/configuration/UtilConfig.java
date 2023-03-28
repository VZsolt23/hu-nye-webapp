package hu.nye.webapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration of util beans.
 */
@Configuration
public class UtilConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
