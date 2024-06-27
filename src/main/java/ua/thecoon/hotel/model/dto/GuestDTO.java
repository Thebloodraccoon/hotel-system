package ua.thecoon.hotel.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class GuestDTO {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phoneNum;

    @NotBlank
    private String passportNum;

    @NotNull
    private HotelItemDTO hotelItemDTO;

    private List<BookingDTO> bookings;
    private List<PaymentDTO> payments;
}