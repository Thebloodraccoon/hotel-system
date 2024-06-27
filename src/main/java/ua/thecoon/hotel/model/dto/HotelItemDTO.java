package ua.thecoon.hotel.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HotelItemDTO {
    private Long id;
    private String name;
    private String address;
    private String contactNum;
    private Date createdAt;
}
