package ua.thecoon.hotel.model.mapper;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.thecoon.hotel.config.MapperTestConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MapperTestConfig.class})
public class MapperTestParent {
    @Autowired
    protected HotelMapper hotelMapper;
    @Autowired
    protected RoomMapper roomMapper;
    @Autowired
    protected ServiceMapper serviceMapper;
    @Autowired
    protected UserMapper userMapper;
}
