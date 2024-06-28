package ua.thecoon.hotel.model.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.thecoon.hotel.model.dto.ServiceDTO;
import ua.thecoon.hotel.model.entity.Service;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceMapper {
    ServiceDTO toServiceDto(Service service);
    Service toService(ServiceDTO serviceDTO);
}
