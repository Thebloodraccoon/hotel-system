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
@Table(name = "t_room")
@ToString(exclude = "hotel")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price_per_night", nullable = false)
    private Double pricePerNight;

    @Column(name = "price_per_night", nullable = false)
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private RoomType type;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;
}