package ua.thecoon.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.hotel.model.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
