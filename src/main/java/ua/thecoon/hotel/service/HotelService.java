package ua.thecoon.hotel.service;

import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.entity.Hotel;
import java.util.List;

public interface HotelService {
    Hotel getHotel(Long id) throws EntityNotFoundException;
    List<Hotel> getAllHotels();
    Hotel updateHotel(Long id, Hotel hotel) throws EntityNotFoundException;
    Hotel saveHotel(Hotel hotel);
    boolean deleteHotel(Long id) throws EntityNotFoundException;
}
