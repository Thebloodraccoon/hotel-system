package ua.thecoon.hotel.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HotelDTO {
    private Long id;
    private String name;
    private String address;
    private String contactNum;
    private Date createdAt;
    private List<GuestDTO> guests;
    private List<UserDTO> users;
    private List<RoomDTO> rooms;
}