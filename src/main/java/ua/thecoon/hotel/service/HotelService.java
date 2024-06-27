package ua.thecoon.hotel.service;

import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.HotelDTO;
import java.util.List;

public interface HotelService {
    HotelDTO getHotel(Long id) throws EntityNotFoundException;
    List<HotelDTO> getAllHotels();
    HotelDTO updateHotel(Long id, HotelDTO hotel) throws EntityNotFoundException;
    HotelDTO saveHotel(HotelDTO hotel);
    boolean deleteHotel(Long id) throws EntityNotFoundException;
}
