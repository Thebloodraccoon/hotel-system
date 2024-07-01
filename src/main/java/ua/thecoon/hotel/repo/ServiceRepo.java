package ua.thecoon.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.hotel.model.entity.Service;

public interface ServiceRepo extends JpaRepository<Service, Long> {
}
