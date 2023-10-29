package br.com.gotea.controller.dto.request;

import br.com.gotea.domain.enums.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserModelRequestDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Role role;
}
