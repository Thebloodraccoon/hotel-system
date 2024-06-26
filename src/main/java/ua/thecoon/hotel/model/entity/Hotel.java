package ua.thecoon.hotel.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Hotel")
@Table(name = "t_hotels")
@ToString
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact_num", nullable = false, unique = true)
    private String contactNum;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @OneToMany(mappedBy = "hotel")
    private List<Guest> guests;

    @OneToMany(mappedBy = "hotel")
    private List<User> users;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}