package ua.thecoon.hotel.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ua.thecoon.hotel.config.ServiceConfig;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.HotelDTO;
import ua.thecoon.hotel.model.entity.Hotel;
import ua.thecoon.hotel.model.mapper.HotelMapper;
import ua.thecoon.hotel.repo.HotelRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {ServiceConfig.class})
public class HotelServiceTest {

    @Mock
    private HotelRepo hotelRepo;

    @Mock
    private HotelMapper hotelMapper;

    @InjectMocks
    private HotelServiceImpl hotelService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllHotelsTest_success() {

    }

    @Test
    public void getHotelTest_success() throws EntityNotFoundException {

    }

    @Test
    public void saveHotelTest_success() {

    }

    @Test
    public void updateHotelTest_success() throws EntityNotFoundException {

    }

    @Test
    public void deleteHotelTest_success() throws EntityNotFoundException {

    }
}