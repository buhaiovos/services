package ua.osb.bdcalculation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.osb.bdcalculation.services.CalculationService;
import ua.osb.bdcalculation.services.CalculationServiceImpl;

@Configuration
public class ServiceConfig {
    @Bean
    public CalculationService calculationService() {
        return new CalculationServiceImpl();
    }
}
