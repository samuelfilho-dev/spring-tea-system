package br.com.gotea.service.impl;

import br.com.gotea.controller.dto.request.UserModelRequestDto;
import br.com.gotea.domain.model.UserModel;
import br.com.gotea.domain.repository.UserModelRepository;
import br.com.gotea.service.UserModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserModelServiceImpl implements UserModelService {

    private final UserModelRepository repository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserModel> findAll() {
        return this.repository.findAll();
    }

    @Override
    public UserModel findById(UUID id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("This User has not exists"));
    }

    @Override
    public UserModel createUserModel(UserModelRequestDto data) {

        var newUserModel = new UserModel();

        newUserModel.setFirstName(data.getFirstName());
        newUserModel.setLastName(data.getLastName());
        newUserModel.setEmail(data.getEmail());
        newUserModel.setPassword(passwordEncoder.encode(data.getPassword()));
        newUserModel.setRole(data.getRole());

        this.repository.save(newUserModel);

        return newUserModel;
    }

    @Override
    public UserModel updateUserModel(UUID id, UserModelRequestDto data) {

        var dbUserModel = findById(id);

        dbUserModel.setFirstName(data.getFirstName());
        dbUserModel.setLastName(data.getLastName());
        dbUserModel.setEmail(data.getEmail());
        dbUserModel.setRole(data.getRole());

        this.repository.save(dbUserModel);

        return dbUserModel;
    }

    @Override
    public void deleteUserModel(UUID id) {
        var dbUser = findById(id);
        this.repository.delete(dbUser);
    }
}
