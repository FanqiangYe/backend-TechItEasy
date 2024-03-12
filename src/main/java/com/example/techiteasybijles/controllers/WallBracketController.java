package com.example.techiteasybijles.controllers;

import com.example.techiteasybijles.dtos.WallBracketDto;
import com.example.techiteasybijles.dtosInput.WallBracketInputDto;
import com.example.techiteasybijles.models.WallBracket;
import com.example.techiteasybijles.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @GetMapping("/wall-brackets")
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {
        return ResponseEntity.ok(wallBracketService.getWallBrackets());
    }

    @GetMapping("/wall-brackets/{id}")
    public ResponseEntity<WallBracketDto> getWallBracket(@PathVariable Long id) {
        WallBracketDto wallBracket = wallBracketService.getWallBracket(id);
        return ResponseEntity.ok(wallBracket);
    }

    @PostMapping("/wall-brackets")
    public ResponseEntity<WallBracket> addWallBracket(@RequestBody WallBracketInputDto wallBracket) {
        WallBracket savedWallBracket = wallBracketService.saveWallBracket(wallBracket);
        return ResponseEntity.created(null).body(savedWallBracket);
    }

    @PutMapping("/wall-brackets/{id}")
    public ResponseEntity<Void> updateWallBracket(@RequestBody WallBracketInputDto wallBracket,
                                                  @PathVariable Long id) {
        wallBracketService.updateWallBracket(wallBracket, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/wall-brackets/{id}")
    public ResponseEntity<Void> deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }
}
