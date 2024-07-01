package ua.thecoon.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.hotel.model.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}
