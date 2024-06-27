package ua.thecoon.hotel.model.dto;

import lombok.Data;
import ua.thecoon.hotel.model.entity.Guest;
import ua.thecoon.hotel.model.entity.Room;
import ua.thecoon.hotel.model.entity.User;

import java.util.Date;
import java.util.List;

@Data
public class HotelDTO {
    private Long id;
    private String name;
    private String address;
    private String contactNum;
    private Date createdAt;
//    private List<Guest> guests;
//    private List<User> users;
    private List<RoomDTO> rooms;
}