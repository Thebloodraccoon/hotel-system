package ua.thecoon.hotel.repo;

import org.springframework.data.repository.CrudRepository;
import ua.thecoon.hotel.model.entity.Guest;

public interface GuestRepo extends CrudRepository<Guest, Long> {
}
