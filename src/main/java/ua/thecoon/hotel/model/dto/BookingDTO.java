package ua.thecoon.hotel.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class BookingDTO {
    private Long id;

    @NotNull
    private Date checkInDate;

    @NotNull
    private Date checkOutDate;

    @NotNull
    private Double totalPrice;

    @NotNull
    private Long roomId;

    @NotNull
    private Long guestId;

    private Long serviceId;
}