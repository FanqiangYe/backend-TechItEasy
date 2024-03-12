package com.example.techiteasybijles.services;

import com.example.techiteasybijles.dtos.RemoteControllerDto;
import com.example.techiteasybijles.dtosInput.RemoteControllerInputDto;
import com.example.techiteasybijles.exceptions.RecordNotFoundException;
import com.example.techiteasybijles.models.RemoteController;
import com.example.techiteasybijles.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public List<RemoteControllerDto> getRemoteControllers() {
        List<RemoteController> remoteControllers = remoteControllerRepository.findAll();
        List<RemoteControllerDto> remoteControllerDtos = new ArrayList<>();
        for (RemoteController remoteController : remoteControllers) {
            RemoteControllerDto dto = remoteControllerToDto(remoteController);
            remoteControllerDtos.add(dto);
        }

        return remoteControllerDtos;
    }

    public RemoteControllerDto getRemoteController(Long id) {
        Optional<RemoteController> optionalRemoteController = remoteControllerRepository.findById(id);
        if (optionalRemoteController.isEmpty()) {
            throw new RecordNotFoundException("RemoteController not found with id: " + id);
        } else {
            return remoteControllerToDto(optionalRemoteController.get());
        }
    }

    public RemoteController saveRemoteController(RemoteControllerInputDto dto) {
        RemoteController remoteController = new RemoteController();
        remoteController.setBrand(dto.getBrand());
        remoteController.setName(dto.getName());
        remoteController.setPrice(dto.getPrice());
        remoteController.setCompatibleWith(dto.getCompatibleWith());
        remoteController.setBatteryType(dto.getBatteryType());
        remoteController.setOriginalStock(dto.getOriginalStock());
        remoteControllerRepository.save(remoteController);
        return remoteController;
    }

    public RemoteControllerDto updateRemoteController(RemoteControllerInputDto newRemoteController, Long id) {
        Optional<RemoteController> remoteController = remoteControllerRepository.findById(id);

        if (remoteController.isEmpty()) {
            throw new RecordNotFoundException("RemoteController not found with id: " + id);
        } else {
            RemoteController existingRemoteController = remoteController.get();

            existingRemoteController.setBrand(newRemoteController.getBrand());
            existingRemoteController.setName(newRemoteController.getName());
            existingRemoteController.setPrice(newRemoteController.getPrice());
            existingRemoteController.setCompatibleWith(newRemoteController.getCompatibleWith());
            existingRemoteController.setBatteryType(newRemoteController.getBatteryType());
            existingRemoteController.setOriginalStock(newRemoteController.getOriginalStock());

            RemoteController returnRemoteController = remoteControllerRepository.save(existingRemoteController);

            return remoteControllerToDto(returnRemoteController);
        }
    }

    public void deleteRemoteController(Long id) {
        Optional<RemoteController> remoteController = remoteControllerRepository.findById(id);
        if (remoteController.isEmpty()) {
            throw new RecordNotFoundException("RemoteController not found with id: " + id);
        } else {
            remoteControllerRepository.deleteById(id);
        }
    }

    private RemoteControllerDto remoteControllerToDto(RemoteController remoteController) {
        RemoteControllerDto dto = new RemoteControllerDto();
        dto.setBrand(remoteController.getBrand());
        dto.setName(remoteController.getName());
        dto.setPrice(remoteController.getPrice());
        dto.setCompatibleWith(remoteController.getCompatibleWith());
        dto.setBatteryType(remoteController.getBatteryType());
        dto.setOriginalStock(remoteController.getOriginalStock());
        return dto;
    }
}
