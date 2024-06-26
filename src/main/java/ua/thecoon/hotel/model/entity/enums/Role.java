package ua.thecoon.hotel.model.entity.enums;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public enum Role {
    ADMIN("Admin"),
    EMPLOYEE("Employee");

    private final String displayName;
}