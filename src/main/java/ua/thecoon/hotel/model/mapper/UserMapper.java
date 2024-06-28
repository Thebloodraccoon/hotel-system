package ua.thecoon.hotel.model.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.thecoon.hotel.model.dto.UserDTO;
import ua.thecoon.hotel.model.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDTO toUserDto(User user);
    User toUser(UserDTO userDTO);
}
