package com.example.techiteasybijles.services;

import com.example.techiteasybijles.dtos.WallBracketDto;
import com.example.techiteasybijles.dtosInput.WallBracketInputDto;
import com.example.techiteasybijles.exceptions.RecordNotFoundException;
import com.example.techiteasybijles.models.WallBracket;
import com.example.techiteasybijles.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracketDto> getWallBrackets() {
        List<WallBracket> wallBrackets = wallBracketRepository.findAll();
        List<WallBracketDto> wallBracketDtos = new ArrayList<>();
        for (WallBracket wallBracket : wallBrackets) {
            WallBracketDto dto = wallBracketToDto(wallBracket);
            wallBracketDtos.add(dto);
        }

        return wallBracketDtos;
    }

    public WallBracketDto getWallBracket(Long id) {
        Optional<WallBracket> optionalWallBracket = wallBracketRepository.findById(id);
        if (optionalWallBracket.isEmpty()) {
            throw new RecordNotFoundException("WallBracket not found with id: " + id);
        } else {
            return wallBracketToDto(optionalWallBracket.get());
        }
    }

    public WallBracket saveWallBracket(WallBracketInputDto dto) {
        WallBracket wallBracket = new WallBracket();
        wallBracket.setName(dto.getName());
        wallBracket.setSize(dto.getSize());
        wallBracket.setPrice(dto.getPrice());
        wallBracket.setAdjustable(dto.getAdjustable());
        wallBracketRepository.save(wallBracket);
        return wallBracket;
    }

    public WallBracketDto updateWallBracket(WallBracketInputDto newWallBracket, Long id) {
        Optional<WallBracket> wallBracket = wallBracketRepository.findById(id);

        if (wallBracket.isEmpty()) {
            throw new RecordNotFoundException("WallBracket not found with id: " + id);
        } else {
            WallBracket existingWallBracket = wallBracket.get();

            existingWallBracket.setName(newWallBracket.getName());
            existingWallBracket.setSize(newWallBracket.getSize());
            existingWallBracket.setPrice(newWallBracket.getPrice());
            existingWallBracket.setAdjustable(newWallBracket.getAdjustable());

            WallBracket returnWallBracket = wallBracketRepository.save(existingWallBracket);

            return wallBracketToDto(returnWallBracket);
        }
    }

    public void deleteWallBracket(Long id) {
        Optional<WallBracket> wallBracket = wallBracketRepository.findById(id);
        if (wallBracket.isEmpty()) {
            throw new RecordNotFoundException("WallBracket not found with id: " + id);
        } else {
            wallBracketRepository.deleteById(id);
        }
    }

    private WallBracketDto wallBracketToDto(WallBracket wallBracket) {
        WallBracketDto dto = new WallBracketDto();
        dto.setName(wallBracket.getName());
        dto.setSize(wallBracket.getSize());
        dto.setPrice(wallBracket.getPrice());
        dto.setAdjustable(wallBracket.getAdjustable());
        return dto;
    }
}
