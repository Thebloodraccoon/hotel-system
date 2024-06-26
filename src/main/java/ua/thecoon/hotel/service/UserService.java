package ua.thecoon.hotel.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.entity.User;
import ua.thecoon.hotel.repo.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User getUserById(Long id) throws EntityNotFoundException {
        return userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + id));
    }

    public User getUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Transactional
    public User updateHotel(Long id, User user) throws EntityNotFoundException {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        existingUser.setName(user.getName());
        existingUser.setHotel(user.getHotel());


        return userRepo.save(existingUser);
    }

    @Transactional
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Transactional
    public boolean deleteUser(Long id) throws EntityNotFoundException {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }

        throw new EntityNotFoundException("User not found with id: " + id);
    }
}
