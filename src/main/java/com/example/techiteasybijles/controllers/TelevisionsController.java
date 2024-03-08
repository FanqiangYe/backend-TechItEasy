package com.example.techiteasybijles.controllers;

import com.example.techiteasybijles.exceptions.RecordNotFoundException;
import com.example.techiteasybijles.models.Television;
import com.example.techiteasybijles.repositories.TelevisionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class TelevisionsController {

    private final TelevisionRepository televisionRepository;

    public TelevisionsController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


    @GetMapping("/televisions")
    public ResponseEntity <List<Television>> getAllTelevisions(){
        return ResponseEntity.ok(televisionRepository.findAll());
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id) {
        // Haal de television met het gegeven id uit de database.
        // Het Optional datatype betekend "wel of niet". Als er geen television gevonden wordt, dan is de Optional empty,
        // maar als er wel een television gevonden wordt, dan staat de television in de Optional en kun je deze er uit
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isEmpty()) {
           throw new RecordNotFoundException("No television found with id: " + id);
// Hoeft hier geen "else" te komen?
        }
        return ResponseEntity.ok().body(television.get());
    }

    // Wanneer je een klasse definieert in een programmeertaal zoals Java, kun je die
    // klasse gebruiken als een nieuw datatype om objecten van dat type te maken.
    @PostMapping("/televisions")
    public ResponseEntity<Void> addTelevision (@RequestBody Television television) {
        televisionRepository.save(television);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Television> updateTelevison(@RequestBody Television newTelevision,
                                                  @PathVariable Long id) {
        Optional<Television> television = televisionRepository.findById(id);

        if(television.isEmpty()){
            throw new RecordNotFoundException();
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

            Television updatedTelevision = televisionRepository.save(existingTelevision);

            return ResponseEntity.ok().body(updatedTelevision);
        }
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Void> deleteTelevision (@PathVariable Long id) {
        Optional<Television> television = televisionRepository.findById(id);
        if(television.isEmpty()){
            throw new RecordNotFoundException();
        } else {
            televisionRepository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }
}
