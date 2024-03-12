package com.example.techiteasybijles.services;

import com.example.techiteasybijles.dtos.CiModuleDto;
import com.example.techiteasybijles.dtosInput.CiModuleInputDto;
import com.example.techiteasybijles.exceptions.RecordNotFoundException;
import com.example.techiteasybijles.models.CiModule;
import com.example.techiteasybijles.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CiModuleDto> getCiModules() {
        List<CiModule> ciModules = ciModuleRepository.findAll();
        List<CiModuleDto> ciModuleDtos = new ArrayList<>();
        for (CiModule ciModule : ciModules) {
            CiModuleDto dto = ciModuleToDto(ciModule);
            ciModuleDtos.add(dto);
        }

        return ciModuleDtos;
    }

    public CiModuleDto getCiModule(Long id) {
        Optional<CiModule> optionalCiModule = ciModuleRepository.findById(id);
        if (optionalCiModule.isEmpty()) {
            throw new RecordNotFoundException("CI Module not found with id: " + id);
        } else {
            return ciModuleToDto(optionalCiModule.get());
        }
    }

    public CiModule saveCiModule(CiModuleInputDto dto) {
        CiModule ciModule = new CiModule();
        ciModule.setType(dto.getType());
        ciModule.setName(dto.getName());
        ciModule.setPrice(dto.getPrice());
        ciModuleRepository.save(ciModule);
        return ciModule;
    }

    public CiModuleDto updateCiModule(CiModuleInputDto newCiModule, Long id) {
        Optional<CiModule> ciModule = ciModuleRepository.findById(id);

        if (ciModule.isEmpty()) {
            throw new RecordNotFoundException("CiModule not found with id: " + id);
        } else {
            CiModule existingCiModule = ciModule.get();

            existingCiModule.setType(newCiModule.getType());
            existingCiModule.setName(newCiModule.getName());
            existingCiModule.setPrice(newCiModule.getPrice());

            CiModule returnCiModule = ciModuleRepository.save(existingCiModule);

            return ciModuleToDto(returnCiModule);
        }
    }

    public void deleteCiModule(Long id) {
        Optional<CiModule> ciModule = ciModuleRepository.findById(id);
        if (ciModule.isEmpty()) {
            throw new RecordNotFoundException("CiModule not found with id: " + id);
        } else {
            ciModuleRepository.deleteById(id);
        }
    }

    private CiModuleDto ciModuleToDto(CiModule ciModule) {
        CiModuleDto dto = new CiModuleDto();
        dto.setType(ciModule.getType());
        dto.setName(ciModule.getName());
        dto.setPrice(ciModule.getPrice());
        return dto;
    }
}
