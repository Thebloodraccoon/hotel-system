package ua.thecoon.hotel.repo;

import org.springframework.data.repository.CrudRepository;
import ua.thecoon.hotel.model.entity.Hotel;

public interface HotelRepo extends CrudRepository<Hotel, Long> {
    void delete(Long id);
}
