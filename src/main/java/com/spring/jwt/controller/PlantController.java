package com.spring.jwt.controller;

import com.spring.jwt.dto.ResponceDto;
import com.spring.jwt.entity.Plant;
import com.spring.jwt.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @GetMapping("/getAllPlants")
    public ResponseEntity<ResponceDto> getAllPlants() {
        try {
            List<Plant> plants = plantService.getAllPlants();
            return new ResponseEntity<>(new ResponceDto("Success", plants,false), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponceDto("Unsuccess", e.getMessage(),true), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponceDto> getPlantById(@PathVariable Long id) {
        try {
            Plant plant = plantService.getPlantById(id);
            return new ResponseEntity<>(new ResponceDto(" Success", plant,false), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponceDto("Unsuccess " , e.getMessage(),true), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ResponceDto> createPlant(@RequestBody Plant plant) {
        try {
            Plant createdPlant = plantService.createPlant(plant);
            return new ResponseEntity<>(new ResponceDto("Success", createdPlant,false), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponceDto("Unsuccess", e.getMessage(),true), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponceDto> updatePlant(@PathVariable Long id, @RequestBody Plant plant) {
        try {
            Plant updatedPlant = plantService.updatePlant(id, plant);
            return new ResponseEntity<>(new ResponceDto("Success", updatedPlant,false), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponceDto("Unsuccess",e.getMessage(),true), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponceDto> deletePlant(@PathVariable Long id) {
        try {
            plantService.deletePlant(id);
            return new ResponseEntity<>(new ResponceDto("Success", "Deleted",false), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponceDto("Unsuccess", e.getMessage(),true), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updatePartial")
    public ResponseEntity<ResponceDto> updatePlantPartial(
            @RequestParam Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double temperature,
            @RequestParam(required = false) Double humidity,
            @RequestParam(required = false) String growMedium,
            @RequestParam(required = false) String nutritions,
            @RequestParam(required = false) String containerType,
            @RequestParam(required = false) Double plantHeight,
            @RequestParam(required = false) String comment,
            @RequestParam(required = false) byte[] photo,
            @RequestParam(required = false) LocalDateTime dateTime,
            @RequestParam(required = false) Integer LUX,
            @RequestParam(required = false) Integer PPFD) {

        try {
            Plant updatedPlant = plantService.updatePlantPartially(id, name, temperature, humidity, growMedium, nutritions, containerType, plantHeight, comment, photo, dateTime, LUX, PPFD);
            return new ResponseEntity<>(new ResponceDto("Success", updatedPlant,false), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponceDto("Unsuccess",e.getMessage(),true), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponceDto("Unsuccess",e.getMessage(), true), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
