package br.com.gotea.controller;

import br.com.gotea.controller.dto.request.TeaRequestDto;
import br.com.gotea.domain.model.TeaModel;
import br.com.gotea.service.TeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/teas")
@RequiredArgsConstructor
public class TeaController {

    private final TeaService teaService;

    @GetMapping("")
    public ResponseEntity<List<TeaModel>> listTea() {
        var teas = this.teaService.findAll();
        return new ResponseEntity<>(teas, HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeaModel> findById(@PathVariable UUID id) {
        var tea = this.teaService.findById(id);
        return new ResponseEntity<>(tea, HttpStatus.I_AM_A_TEAPOT);
    }

    @PostMapping("")
    public ResponseEntity<TeaModel> createTea(@RequestBody TeaRequestDto data) {
        var tea = this.teaService.createTeaModel(data);
        return new ResponseEntity<>(tea, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeaModel> updateTea(@PathVariable UUID id, @RequestBody TeaRequestDto data) {
        var tea = this.teaService.updateTeaModel(id, data);
        return new ResponseEntity<>(tea, HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Void> deleteTea(@PathVariable UUID id) {
        this.teaService.deleteTeaModel(id);
        return ResponseEntity.noContent().build();
    }
}
