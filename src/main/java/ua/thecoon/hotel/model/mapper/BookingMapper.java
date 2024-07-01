package ua.thecoon.hotel.model.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.thecoon.hotel.model.dto.BookingDTO;
import ua.thecoon.hotel.model.entity.Booking;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingMapper {
    BookingDTO toBookingDTO(Booking booking);
    Booking toBooking(BookingDTO bookingDTO);
}
