package com.example.techiteasybijles.controllers;

import com.example.techiteasybijles.dtos.TelevisionDto;
import com.example.techiteasybijles.dtosInput.TelevisionInputDto;
import com.example.techiteasybijles.models.Television;
import com.example.techiteasybijles.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/televisions") -> dit had ook gekund voor de uri endpoint
@RestController
public class TelevisionsController {

    private final TelevisionService televisionService;

    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping("/televisions")
    public ResponseEntity <List<TelevisionDto>> getAllTelevisions(){
        return ResponseEntity.ok(televisionService.getTelevisions());
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id) {
        // Haal de television met het gegeven id uit de database.
        // Het Optional datatype betekend "wel of niet". Als er geen television gevonden wordt, dan is de Optional empty,
        // maar als er wel een television gevonden wordt, dan staat de television in de Optional en kun je deze er uit
        TelevisionDto television = televisionService.getTelevision(id);
        return ResponseEntity.ok(television);
    }

    // Wanneer je een klasse definieert in een programmeertaal zoals Java, kun je die
    // klasse gebruiken als een nieuw datatype om objecten van dat type te maken.
    @PostMapping("/televisions")
    public ResponseEntity<Television> addTelevision (@RequestBody TelevisionInputDto television) {
        Television savedTelevision = televisionService.saveTelevision(television);
        return ResponseEntity.created(null).body(savedTelevision);
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Void> updateTelevison(@RequestBody TelevisionInputDto television,
                                                  @PathVariable Long id) {
            televisionService.updateTelevision(television, id);
            return ResponseEntity.noContent().build();
        }


    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Void> deleteTelevision (@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
}
