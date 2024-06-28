package ua.thecoon.hotel.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.hotel.model.dto.ServiceDTO;
import ua.thecoon.hotel.model.mapper.ServiceMapper;
import ua.thecoon.hotel.repo.ServiceRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService{
    private final ServiceRepo serviceRepo;
    private final ServiceMapper serviceMapper;

    @Override
    public List<ServiceDTO> getAllServices() {
        List<ua.thecoon.hotel.model.entity.Service> all = (List<ua.thecoon.hotel.model.entity.Service>) serviceRepo.findAll();

        return all.stream()
                .map(serviceMapper::serviceToServiceDTO)
                .collect(Collectors.toList());

    }

    @Override
    public ServiceDTO getServiceById(Long id) {
        return serviceRepo.findById(id)
                .map(serviceMapper::serviceToServiceDTO)
                .orElseThrow(() -> new EntityNotFoundException("Service not found with id " + id));
    }

    @Transactional
    public ServiceDTO createService(@Valid ServiceDTO serviceDTO) {
        ua.thecoon.hotel.model.entity.Service service = serviceMapper.serviceDTOToService(serviceDTO);
        ua.thecoon.hotel.model.entity.Service savedService = serviceRepo.save(service);

        return serviceMapper.serviceToServiceDTO(savedService);
    }

    @Transactional
    public ServiceDTO updateService(Long id, @Valid ServiceDTO serviceDTO) {
        if (!serviceRepo.existsById(id)) {
            throw new EntityNotFoundException("Service not found with id " + id);
        }

        ua.thecoon.hotel.model.entity.Service service = serviceMapper.serviceDTOToService(serviceDTO);
        service.setId(id);
        ua.thecoon.hotel.model.entity.Service updatedService = serviceRepo.save(service);

        return serviceMapper.serviceToServiceDTO(updatedService);
    }

    @Transactional
    public boolean deleteService(Long id) {
        if (serviceRepo.existsById(id)) {
            serviceRepo.deleteById(id);
            return true;
        }

        throw new EntityNotFoundException("Service not found with id: " + id);
    }
}
