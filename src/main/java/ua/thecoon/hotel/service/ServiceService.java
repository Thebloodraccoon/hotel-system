package ua.thecoon.hotel.service;

import ua.thecoon.hotel.model.dto.ServiceDTO;

import java.util.List;

public interface ServiceService {
    List<ServiceDTO> getAllServices();
    ServiceDTO getServiceById(Long id);
    ServiceDTO createService(ServiceDTO service);
    ServiceDTO updateService(Long id, ServiceDTO service);
    boolean deleteService(Long id);
}
