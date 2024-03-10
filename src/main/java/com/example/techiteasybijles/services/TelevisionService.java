package com.example.techiteasybijles.services;

// De reden dat we de servicelaag gebruiken, is zodat de controller clean blijft
// Zorgt voor een georganiseerde project structuur, wat bruikbaarheid voor andere programmeurs verbetert
import com.example.techiteasybijles.exceptions.RecordNotFoundException;
import com.example.techiteasybijles.models.Television;
import com.example.techiteasybijles.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getTelevisions() {
        return televisionRepository.findAll();
    }

    // Optional - is empty of is present. Hij geeft altijd wat terug
    public Television getTelevision(Long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isEmpty()) {
            throw new RecordNotFoundException("Television not found with id: " + id);
        } else {
            return optionalTelevision.get();
        }
    }

    public Television saveTelevision(Television television) {
        televisionRepository.save(television);
        return television;
    }

    public void updateTelevision(Television newTelevision, Long id) {
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
            existingTelevision.setOriginalStock(newTelevision.getOriginalStock());
            existingTelevision.setSold(newTelevision.getSold());
        }
    }

    public void deleteTelevision(Long id){
        Optional<Television> television = televisionRepository.findById(id);
        if(television.isEmpty()){
            throw new RecordNotFoundException("Television not found with id: " + id);
        } else {
            televisionRepository.deleteById(id);
        }
    }
}

