package ua.thecoon.hotel.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.util.Date;

@Data
public class HotelItemDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String contactNum;

    @NotNull
    @PastOrPresent
    private Date createdAt;
}
