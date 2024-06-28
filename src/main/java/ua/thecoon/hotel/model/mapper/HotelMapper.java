package ua.thecoon.hotel.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.thecoon.hotel.model.dto.HotelDTO;
import ua.thecoon.hotel.model.entity.Hotel;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {
    HotelDTO toHotelDTO(Hotel hotel);
    Hotel toHotel(HotelDTO hotelDTO);
}