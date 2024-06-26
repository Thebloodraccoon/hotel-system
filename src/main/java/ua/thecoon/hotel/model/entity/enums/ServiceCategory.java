package ua.thecoon.hotel.model.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString(exclude = "price")
@RequiredArgsConstructor
public enum ServiceCategory {
    CONCIERGE("Concierge", 50.0),
    SPA("Spa", 100.0),
    GYM("Gym", 20.0),
    RESTAURANT("Restaurant", 70.0),
    BAR("Bar", 40.0),
    WIFI("WiFi", 10.0),
    PARKING("Parking", 15.0),
    POOL("Pool", 30.0);

    private final String displayName;
    private final double price;
}