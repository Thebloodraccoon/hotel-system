package ua.thecoon.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.hotel.model.entity.Guest;

public interface GuestRepo extends JpaRepository<Guest, Long> {
}
