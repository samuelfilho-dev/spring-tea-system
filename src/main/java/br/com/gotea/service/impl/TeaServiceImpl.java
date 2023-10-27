package br.com.gotea.service.impl;

import br.com.gotea.controller.dto.request.TeaRequestDto;
import br.com.gotea.domain.model.Tea;
import br.com.gotea.domain.repository.TeaRepository;
import br.com.gotea.service.TeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeaServiceImpl implements TeaService {

    private final TeaRepository repository;

    @Override
    public List<Tea> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Tea findById(UUID id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tea has not exists"));
    }

    @Override
    public Tea createTeaModel(TeaRequestDto data) {

        var newTea = new Tea();

        newTea.setName(data.getName());
        newTea.setDescription(data.getDescription());
        newTea.setCategory(data.getCategory());
        newTea.setOriginCountry(data.getOriginCountry());
        newTea.setInfusionTime(data.getInfusionTime());
        newTea.setWaterTemperature(data.getWaterTemperature());
        newTea.setCaffeineContent(data.getCaffeineContent());
        newTea.setPrice(data.getPrice());
        newTea.setTasteRating(data.getTasteRating());
        newTea.setImageUrl(data.getImageUrl());

        this.repository.save(newTea);

        return newTea;
    }

    @Override
    public Tea updateTeaModel(UUID id, TeaRequestDto data) {

        var updatedTea = findById(id);

        updatedTea.setName(data.getName());
        updatedTea.setDescription(data.getDescription());
        updatedTea.setCategory(data.getCategory());
        updatedTea.setOriginCountry(data.getOriginCountry());
        updatedTea.setInfusionTime(data.getInfusionTime());
        updatedTea.setWaterTemperature(data.getWaterTemperature());
        updatedTea.setCaffeineContent(data.getCaffeineContent());
        updatedTea.setPrice(data.getPrice());
        updatedTea.setTasteRating(data.getTasteRating());
        updatedTea.setImageUrl(data.getImageUrl());

        this.repository.save(updatedTea);

        return updatedTea;

    }

    @Override
    public void deleteTeaModel(UUID id) {
        var dbTea = findById(id);
        this.repository.delete(dbTea);
    }
}
