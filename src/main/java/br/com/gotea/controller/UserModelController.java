package br.com.gotea.controller;

import br.com.gotea.controller.dto.request.UserModelRequestDto;
import br.com.gotea.domain.model.UserModel;
import br.com.gotea.service.UserModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserModelController {

    private final UserModelService userModelService;

    @GetMapping("")
    public ResponseEntity<List<UserModel>> listAllUsers() {
        var users = this.userModelService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable UUID id) {
        var user = this.userModelService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<UserModel> createUserModel(@RequestBody UserModelRequestDto data) {
        var user = this.userModelService.createUserModel(data);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUserModel(@PathVariable UUID id, @RequestBody UserModelRequestDto data) {
        var user = this.userModelService.updateUserModel(id, data);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserModel(@PathVariable UUID id) {
        this.userModelService.deleteUserModel(id);
        return ResponseEntity.noContent().build();
    }
}
