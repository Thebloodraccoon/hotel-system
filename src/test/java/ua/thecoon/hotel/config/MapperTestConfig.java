package ua.thecoon.hotel.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.thecoon.hotel.model.mapper.HotelMapper;
import ua.thecoon.hotel.model.mapper.HotelMapperImpl;
import ua.thecoon.hotel.model.mapper.RoomMapper;
import ua.thecoon.hotel.model.mapper.RoomMapperImpl;
import ua.thecoon.hotel.model.mapper.ServiceMapper;
import ua.thecoon.hotel.model.mapper.ServiceMapperImpl;
import ua.thecoon.hotel.model.mapper.UserMapper;
import ua.thecoon.hotel.model.mapper.UserMapperImpl;

@Configuration
public class MapperTestConfig {
    @Bean
    public HotelMapper hotelMapper() {
        return new HotelMapperImpl();
    }
    @Bean
    public RoomMapper roomMapper() {
        return new RoomMapperImpl();
    }
    @Bean
    public ServiceMapper serviceMapper() {
        return new ServiceMapperImpl();
    }
    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }
}
