package ua.thecoon.hotel.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ua.thecoon.hotel.config.ServiceConfig;
import ua.thecoon.hotel.model.mapper.HotelMapper;
import ua.thecoon.hotel.repo.HotelRepo;

@SpringBootTest
@ContextConfiguration(classes = {ServiceConfig.class})
public class HotelServiceTest extends ServiceConfig {
    @Mock
    private HotelRepo hotelRepo;
    private HotelMapper hotelMapper;
    private HotelService hotelService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        hotelMapper = getHotelMapper();
        hotelService = new HotelServiceImpl(hotelRepo, hotelMapper);
    }

    @Test
    public void getAllUserTest_success() {
        
    }
}