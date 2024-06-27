package ua.thecoon.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.hotel.model.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Long> {
}
