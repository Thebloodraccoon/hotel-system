package ua.thecoon.hotel.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.entity.Hotel;
import ua.thecoon.hotel.repo.HotelRepo;

import java.util.List;


@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepo hotelRepo;

    public Hotel getHotel(Long id) throws EntityNotFoundException {
        return hotelRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + id));
    }

    public List<Hotel> getAllHotels() {
        return (List<Hotel>) hotelRepo.findAll();
    }

    @Transactional
    public Hotel updateHotel(Long id, Hotel updatedHotel) throws EntityNotFoundException {
        Hotel existingHotel = hotelRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + id));

        existingHotel.setName(updatedHotel.getName());
        existingHotel.setAddress(updatedHotel.getAddress());
        existingHotel.setContactNum(updatedHotel.getContactNum());
        existingHotel.setCreatedAt(updatedHotel.getCreatedAt());


        return hotelRepo.save(existingHotel);
    }

    @Transactional
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Transactional
    public boolean deleteHotel(Long id) throws EntityNotFoundException {
        if (hotelRepo.existsById(id)) {
            hotelRepo.deleteById(id);
            return true;
        }

        throw new EntityNotFoundException("Hotel not found with id: " + id);
    }
}
