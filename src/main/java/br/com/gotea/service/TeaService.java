package br.com.gotea.service;

import br.com.gotea.controller.dto.request.TeaRequestDto;
import br.com.gotea.domain.model.Tea;

import java.util.List;
import java.util.UUID;

public interface TeaService {

    List<Tea> findAll();

    Tea findById(UUID id);

    Tea createTeaModel(TeaRequestDto data);

    Tea updateTeaModel(UUID id, TeaRequestDto data);

    void deleteTeaModel(UUID id);
}
