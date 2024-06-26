package ua.thecoon.hotel.model.entity;
import jakarta.persistence.*;
import lombok.*;
import ua.thecoon.hotel.model.entity.enums.Role;

import java.util.Date;

@Data
@Entity(name = "User")
@Table(name = "t_user")
@ToString(exclude = "hotel")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_num", nullable = false, length = 20)
    private String phoneNum;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
}