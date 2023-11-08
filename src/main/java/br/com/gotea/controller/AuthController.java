package br.com.gotea.controller;

import br.com.gotea.controller.dto.request.LoginRequestDto;
import br.com.gotea.controller.dto.response.AuthResponseDto;
import br.com.gotea.domain.repository.UserModelRepository;
import br.com.gotea.service.impl.JwtUtilServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtilServiceImpl jwtUtilService;

    @PostMapping("")
    public ResponseEntity<AuthResponseDto> generateToken(@RequestBody LoginRequestDto data) {
        var token = jwtUtilService.generateToken(data.getEmail());
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}
