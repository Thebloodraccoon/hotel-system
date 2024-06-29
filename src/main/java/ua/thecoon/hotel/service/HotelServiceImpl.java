package ua.thecoon.hotel.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.HotelDTO;
import ua.thecoon.hotel.model.entity.Hotel;
import ua.thecoon.hotel.model.mapper.HotelMapper;
import ua.thecoon.hotel.repo.HotelRepo;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepo hotelRepo;
    private final HotelMapper hotelMapper;

    public HotelDTO getHotel(Long id) throws EntityNotFoundException {
        Hotel hotel = hotelRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + id));
        return hotelMapper.toHotelDTO(hotel);
    }

    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotels = hotelRepo.findAll();
        return hotels.stream()
                .map(hotelMapper::toHotelDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public HotelDTO updateHotel(Long id, HotelDTO updatedHotelDTO) throws EntityNotFoundException {
        Hotel existingHotel = hotelRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + id));

        Hotel updatedHotel = hotelMapper.toHotel(updatedHotelDTO);
        existingHotel.setName(updatedHotel.getName());
        existingHotel.setAddress(updatedHotel.getAddress());
        existingHotel.setContactNum(updatedHotel.getContactNum());
        existingHotel.setCreatedAt(updatedHotel.getCreatedAt());

        return hotelMapper.toHotelDTO(hotelRepo.save(existingHotel));
    }

    @Transactional
    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        Hotel hotel = hotelMapper.toHotel(hotelDTO);
        return hotelMapper.toHotelDTO(hotelRepo.save(hotel));
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