package com.example.techiteasybijles.controllers;

import com.example.techiteasybijles.dtos.CiModuleDto;
import com.example.techiteasybijles.dtosInput.CiModuleInputDto;
import com.example.techiteasybijles.models.CiModule;
import com.example.techiteasybijles.services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CiModuleController {

    private final CiModuleService ciModuleService;

    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @GetMapping("/ci-modules")
    public ResponseEntity<List<CiModuleDto>> getAllCiModules() {
        return ResponseEntity.ok(ciModuleService.getCiModules());
    }

    @GetMapping("/ci-modules/{id}")
    public ResponseEntity<CiModuleDto> getCiModule(@PathVariable Long id) {
        CiModuleDto ciModule = ciModuleService.getCiModule(id);
        return ResponseEntity.ok(ciModule);
    }

    @PostMapping("/ci-modules")
    public ResponseEntity<CiModule> addCiModule(@RequestBody CiModuleInputDto ciModule) {
        CiModule savedCiModule = ciModuleService.saveCiModule(ciModule);
        return ResponseEntity.created(null).body(savedCiModule);
    }

    @PutMapping("/ci-modules/{id}")
    public ResponseEntity<Void> updateCiModule(@RequestBody CiModuleInputDto ciModule,
                                               @PathVariable Long id) {
        ciModuleService.updateCiModule(ciModule, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/ci-modules/{id}")
    public ResponseEntity<Void> deleteCiModule(@PathVariable Long id) {
        ciModuleService.deleteCiModule(id);
        return ResponseEntity.noContent().build();
    }
}
