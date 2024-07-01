package ua.thecoon.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.hotel.model.entity.Room;

public interface RoomRepo extends JpaRepository<Room, Long> {
}
