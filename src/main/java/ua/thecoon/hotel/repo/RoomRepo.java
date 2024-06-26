package ua.thecoon.hotel.repo;

import org.springframework.data.repository.CrudRepository;
import ua.thecoon.hotel.model.entity.Room;

import java.math.RoundingMode;

public interface RoomRepo extends CrudRepository<Room, Long> {
}
