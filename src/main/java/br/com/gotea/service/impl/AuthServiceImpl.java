package br.com.gotea.service.impl;

import br.com.gotea.domain.repository.UserModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements UserDetailsService {

    private final UserModelRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("The user or password are incorrect"));
    }
}
