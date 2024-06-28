package ua.thecoon.hotel.model.dto;

import lombok.Data;
import ua.thecoon.hotel.model.entity.enums.ServiceCategory;

@Data
public class ServiceDTO {
    private Long id;
    private String name;
    private String description;
    private ServiceCategory category;
    private double price;
    private Boolean available;
}