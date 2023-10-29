package br.com.gotea.domain.repository;

import br.com.gotea.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByEmail(String email);
}
