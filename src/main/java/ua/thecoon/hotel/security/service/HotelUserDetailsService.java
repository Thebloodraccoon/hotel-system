package ua.thecoon.hotel.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.thecoon.hotel.model.entity.User;
import ua.thecoon.hotel.repo.UserRepo;
import ua.thecoon.hotel.security.model.HotelUserDetails;

@RequiredArgsConstructor
public class HotelUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byEmail = userRepo.findUserByEmail(username);

        if (byEmail == null) {
            throw new UsernameNotFoundException(username);
        }

        return new HotelUserDetails(byEmail);
    }
}
