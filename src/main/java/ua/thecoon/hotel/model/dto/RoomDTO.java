package ua.thecoon.hotel.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


import ua.thecoon.hotel.model.entity.enums.RoomType;

@Data
public class RoomDTO {
    private Long id;

    @NotNull
    @Positive
    private Double roomNumber;

    @NotBlank
    private String description;

    @NotNull
    @Positive
    private Double pricePerNight;

    @NotNull
    @Positive
    private int capacity;

    @NotNull
    private RoomType type;

    @NotNull
    private HotelItemDTO hotel;
}