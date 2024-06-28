package ua.thecoon.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.thecoon.hotel.exception.EntityNotFoundException;
import ua.thecoon.hotel.model.dto.ServiceDTO;
import ua.thecoon.hotel.service.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<ServiceDTO>> getAllService() {
        List<ServiceDTO> allServices = serviceService.getAllServices();

        return ResponseEntity.ok(allServices);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ServiceDTO> getRoomById(@PathVariable Long id) throws EntityNotFoundException {
        ServiceDTO serviceById = serviceService.getServiceById(id);

        return ResponseEntity.ok(serviceById);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ServiceDTO> createService(@RequestBody ServiceDTO serviceDTO) {
        ServiceDTO serviceDTO1 = serviceService.createService(serviceDTO);

        return ResponseEntity.ok(serviceDTO1);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<ServiceDTO> updateHotel(@PathVariable Long id,
                                        @RequestBody ServiceDTO serviceDTO) throws EntityNotFoundException {
        ServiceDTO serviceDTO1 = serviceService.updateService(id, serviceDTO);

        return ResponseEntity.ok(serviceDTO1);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Void> deleteHotel(@PathVariable Long id) throws EntityNotFoundException {
        boolean b = serviceService.deleteService(id);

        return ResponseEntity.noContent().build();
    }
}
