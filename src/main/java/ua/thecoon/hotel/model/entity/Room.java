package ua.thecoon.hotel.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import ua.thecoon.hotel.model.entity.enums.RoomType;
import ua.thecoon.hotel.model.entity.enums.ServiceCategory;

import java.util.Date;
import java.util.List;


@Data
@Entity(name = "Room")
@Table(name = "t_rooms")
@ToString(exclude = "hotel")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number", nullable = false)
    private Double roomNumber;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price_per_night", nullable = false)
    private Double pricePerNight;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private RoomType type;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
}