package ua.thecoon.hotel.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.thecoon.hotel.model.mapper.HotelMapper;
import ua.thecoon.hotel.model.mapper.HotelMapperImpl;

@Configuration
public class ServiceConfig {
    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public HotelMapper getHotelMapper() {
        return new HotelMapperImpl();
    }
}