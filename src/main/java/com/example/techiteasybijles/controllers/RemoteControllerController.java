package com.example.techiteasybijles.controllers;

import com.example.techiteasybijles.dtos.RemoteControllerDto;
import com.example.techiteasybijles.dtosInput.RemoteControllerInputDto;
import com.example.techiteasybijles.models.RemoteController;
import com.example.techiteasybijles.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;

    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @GetMapping("/remote-controllers")
    public ResponseEntity<List<RemoteControllerDto>> getAllRemoteControllers() {
        return ResponseEntity.ok(remoteControllerService.getRemoteControllers());
    }

    @GetMapping("/remote-controllers/{id}")
    public ResponseEntity<RemoteControllerDto> getRemoteController(@PathVariable Long id) {
        RemoteControllerDto remoteController = remoteControllerService.getRemoteController(id);
        return ResponseEntity.ok(remoteController);
    }

    @PostMapping("/remote-controllers")
    public ResponseEntity<RemoteController> addRemoteController(@RequestBody RemoteControllerInputDto remoteController) {
        RemoteController savedRemoteController = remoteControllerService.saveRemoteController(remoteController);
        return ResponseEntity.created(null).body(savedRemoteController);
    }

    @PutMapping("/remote-controllers/{id}")
    public ResponseEntity<Void> updateRemoteController(@RequestBody RemoteControllerInputDto remoteController,
                                                       @PathVariable Long id) {
        remoteControllerService.updateRemoteController(remoteController, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/remote-controllers/{id}")
    public ResponseEntity<Void> deleteRemoteController(@PathVariable Long id) {
        remoteControllerService.deleteRemoteController(id);
        return ResponseEntity.noContent().build();
    }
}
