package ua.thecoon.hotel.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.thecoon.hotel.model.dto.RoomDTO;
import ua.thecoon.hotel.model.entity.Room;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {
    RoomDTO toRoomDto(Room room);
    Room toRoom(RoomDTO roomDTO);
}
