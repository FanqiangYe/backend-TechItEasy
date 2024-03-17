package com.example.techiteasybijles.services;

// De reden dat we de servicelaag gebruiken, is zodat de controller clean blijft
// Zorgt voor een georganiseerde project structuur, wat bruikbaarheid voor andere programmeurs verbetert
import com.example.techiteasybijles.dtos.TelevisionDto;
import com.example.techiteasybijles.dtosInput.TelevisionInputDto;
import com.example.techiteasybijles.exceptions.RecordNotFoundException;
import com.example.techiteasybijles.models.RemoteController;
import com.example.techiteasybijles.models.Television;
import com.example.techiteasybijles.repositories.RemoteControllerRepository;
import com.example.techiteasybijles.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;

    public TelevisionService(TelevisionRepository televisionRepository,
                             RemoteControllerRepository remoteControllerRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public List<TelevisionDto> getTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionDto> televisionDtos = new ArrayList<>();
        // gaat door de lijst van Television, en stopt die in de lege ArrayList van TelevisionDto
        for (Television television : televisions) {
            TelevisionDto dto = TelevisionToDto(television);
            televisionDtos.add(dto);
        }

        return televisionDtos;
    }

    // Optional - is empty of is present. Hij geeft altijd wat terug
    public TelevisionDto getTelevision(Long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isEmpty()) {
            throw new RecordNotFoundException("Television not found with id: " + id);
        } else {
        return TelevisionToDto(optionalTelevision.get());
        }
    }

    public Television saveTelevision(TelevisionInputDto dto) {
        Television television = new Television();
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        televisionRepository.save(television);
        return television;
    }

    // Je verwacht een response van de DTO terug, dus geen void
    public TelevisionDto updateTelevision(TelevisionInputDto newTelevision, Long id) {
        Optional<Television> television = televisionRepository.findById(id);

        if (television.isEmpty()) {
            throw new RecordNotFoundException("Television not found with id: " + id);
        } else {
            Television existingTelevision = television.get();

            existingTelevision.setBrand(newTelevision.getBrand());
            existingTelevision.setName(newTelevision.getName());
            existingTelevision.setPrice(newTelevision.getPrice());
            existingTelevision.setAvailableSize(newTelevision.getAvailableSize());
            existingTelevision.setRefreshRate(newTelevision.getRefreshRate());
            existingTelevision.setScreenType(newTelevision.getScreenType());
            existingTelevision.setScreenQuality(newTelevision.getScreenQuality());
            existingTelevision.setSmartTv(newTelevision.getSmartTv());
            existingTelevision.setWifi(newTelevision.getWifi());
            existingTelevision.setVoiceControl(newTelevision.getVoiceControl());
            existingTelevision.setHdr(newTelevision.getHdr());
            existingTelevision.setBluetooth(newTelevision.getBluetooth());
            existingTelevision.setAmbiLight(newTelevision.getAmbiLight());

            Television returnTelevision = televisionRepository.save(existingTelevision);

            return TelevisionToDto(returnTelevision);
        }
    }

    public void deleteTelevision(Long id) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isEmpty()) {
            throw new RecordNotFoundException("Television not found with id: " + id);
        } else {
            televisionRepository.deleteById(id);
        }
    }


    private TelevisionDto TelevisionToDto(Television television) {
        TelevisionDto dto = new TelevisionDto();
        dto.setId(television.getId());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setRemoteController(television.getRemoteController());
        return dto;
    }

    public void assignRemoteControllerToTelevision(Long televisionId, Long remotecontrollerId) {
        Optional<Television> optionalTelevision = televisionRepository.findById(televisionId);
        Optional<RemoteController> optionalRemoteController = remoteControllerRepository.findById(remotecontrollerId);
        if (optionalTelevision.isEmpty() && optionalRemoteController.isEmpty()){
          throw new RecordNotFoundException("Television of remote controller niet gevonden");
        } else {
            Television television = optionalTelevision.get();
            RemoteController remoteController = optionalRemoteController.get();
            television.setRemoteController(remoteController);
            televisionRepository.save(television);
        }
    }
}

