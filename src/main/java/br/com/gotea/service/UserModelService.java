package br.com.gotea.service;

import br.com.gotea.controller.dto.request.UserModelRequestDto;
import br.com.gotea.domain.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserModelService {

    List<UserModel> findAll();

    UserModel findById(UUID id);

    UserModel createUserModel(UserModelRequestDto data);

    UserModel updateUserModel(UUID id, UserModelRequestDto data);

    void deleteUserModel(UUID id);
}
