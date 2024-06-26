package ua.thecoon.hotel.model.entity.enums;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public enum RoomType {
    SINGLE("Single"),
    DOUBLE("Double"),
    TWIN("Twin"),
    SUITE("Suite"),
    FAMILY("Family"),
    CONNECTING("Connecting");

    private final String displayName;
}