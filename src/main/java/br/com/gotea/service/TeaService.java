package br.com.gotea.service;

import br.com.gotea.controller.dto.request.TeaRequestDto;
import br.com.gotea.domain.model.TeaModel;

import java.util.List;
import java.util.UUID;

public interface TeaService {

    List<TeaModel> findAll();

    TeaModel findById(UUID id);

    TeaModel createTeaModel(TeaRequestDto data);

    TeaModel updateTeaModel(UUID id, TeaRequestDto data);

    void deleteTeaModel(UUID id);
}
