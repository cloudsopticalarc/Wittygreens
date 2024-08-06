package com.spring.jwt.service;

import com.spring.jwt.Interfaces.PlantRepository;
import com.spring.jwt.entity.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    public List<Plant> getAllPlants() {
        List<Plant> plants = plantRepository.findAll();
        if (plants.isEmpty()) {
            throw new RuntimeException("No plants found");
        }
        return plants;
    }

    public Plant getPlantById(Long id) {
        return plantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found with ID: " + id));
    }

    public Plant createPlant(Plant plant) {
        try {
            return plantRepository.save(plant);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create plant: " + e.getMessage());
        }
    }

    public Plant updatePlant(Long id, Plant plant) {
        if (!plantRepository.existsById(id)) {
            throw new RuntimeException("Plant not found with ID: " + id);
        }
        try {
            Plant existingPlant = plantRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Plant not found with ID: " + id));

            existingPlant.setName(plant.getName());
            existingPlant.setTemperature(plant.getTemperature());
            existingPlant.setHumidity(plant.getHumidity());
            existingPlant.setGrowMedium(plant.getGrowMedium());
            existingPlant.setNutritions(plant.getNutritions());
            existingPlant.setContainerType(plant.getContainerType());
            existingPlant.setPlantHeight(plant.getPlantHeight());
            existingPlant.setComment(plant.getComment());
            existingPlant.setPhoto(plant.getPhoto());
            existingPlant.setDateTime(plant.getDateTime());
            existingPlant.setLUX(plant.getLUX());
            existingPlant.setPPFD(plant.getPPFD());

            return plantRepository.save(existingPlant);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update plant: " + e.getMessage());
        }
    }

    public void deletePlant(Long id) {
        if (!plantRepository.existsById(id)) {
            throw new RuntimeException("Plant ID not found: " + id);
        }
        plantRepository.deleteById(id);
    }

    public Plant updatePlantPartially(Long id, String name, Double temperature, Double humidity, String growMedium, String nutritions, String containerType, Double plantHeight, String comment, byte[] photo, LocalDateTime dateTime, Integer LUX, Integer PPFD){
        Plant existingPlant = plantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found with ID: " + id));


        if (name != null) existingPlant.setName(name);
        if (temperature != null) existingPlant.setTemperature(temperature);
        if (humidity != null) existingPlant.setHumidity(humidity);
        if (growMedium != null) existingPlant.setGrowMedium(growMedium);
        if (nutritions != null) existingPlant.setNutritions(nutritions);
        if (containerType != null) existingPlant.setContainerType(containerType);
        if (plantHeight != null) existingPlant.setPlantHeight(plantHeight);
        if (comment != null) existingPlant.setComment(comment);
        if (photo != null) existingPlant.setPhoto(photo);
        if (dateTime != null) existingPlant.setDateTime(dateTime);
        if (LUX != null) existingPlant.setLUX(LUX);
        if (PPFD != null) existingPlant.setPPFD(PPFD);

        return plantRepository.save(existingPlant);
    }
}
