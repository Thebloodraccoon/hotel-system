package ua.thecoon.hotel.repo;

import org.springframework.data.repository.CrudRepository;
import ua.thecoon.hotel.model.entity.Service;

public interface ServiceRepo extends CrudRepository<Service, Long> {
}
