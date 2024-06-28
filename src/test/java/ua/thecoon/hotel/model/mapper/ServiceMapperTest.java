package ua.thecoon.hotel.model.mapper;

import org.junit.jupiter.api.Test;
import ua.thecoon.hotel.model.dto.ServiceDTO;
import ua.thecoon.hotel.model.entity.Service;
import ua.thecoon.hotel.model.entity.enums.ServiceCategory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ServiceMapperTest extends MapperTestParent {
    @Test
    public void serviceToServiceDTOTest_convertSuccessfully() {
        final Service service = new Service();

        service.setId(1L);
        service.setName("TEST NAME");
        service.setDescription("TEST");
        service.setAvailable(true);
        service.setCategory(ServiceCategory.BAR);
        service.setPrice(15.75);


        ServiceDTO serviceDto = serviceMapper.toServiceDto(service);

        assertNotNull(serviceDto);
        assertEquals(serviceDto.getId(), service.getId());
        assertEquals(serviceDto.getName(), service.getName());
        assertEquals(serviceDto.getDescription(), service.getDescription());
        assertEquals(serviceDto.getCategory(), service.getCategory());
        assertEquals(serviceDto.getPrice(), service.getPrice());
        assertEquals(serviceDto.getAvailable(), service.getAvailable());
    }

    @Test
    public void serviceDTOToServiceTest_convertSuccessfully() {
        final ServiceDTO serviceDTO = new ServiceDTO();

        serviceDTO.setId(1L);
        serviceDTO.setName("TEST NAME");
        serviceDTO.setDescription("TEST");
        serviceDTO.setAvailable(true);
        serviceDTO.setCategory(ServiceCategory.BAR);
        serviceDTO.setPrice(15.75);


        Service service = serviceMapper.toService(serviceDTO);

        assertNotNull(service);
        assertEquals(service.getId(), serviceDTO.getId());
        assertEquals(service.getName(), serviceDTO.getName());
        assertEquals(service.getDescription(), serviceDTO.getDescription());
        assertEquals(service.getCategory(), serviceDTO.getCategory());
        assertEquals(service.getPrice(), serviceDTO.getPrice());
        assertEquals(service.getAvailable(), serviceDTO.getAvailable());
    }
}
