package ua.thecoon.hotel.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentDTO {
    private Long id;

    @NotNull
    private Double totalSum;

    @NotBlank
    private String paymentMethod;

    @NotNull
    private Date createdAt;

    @NotNull
    private Long bookingId;

    @NotNull
    private Long guestId;
}