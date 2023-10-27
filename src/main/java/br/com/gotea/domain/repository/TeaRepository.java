package br.com.gotea.domain.repository;

import br.com.gotea.domain.model.Tea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeaRepository extends JpaRepository<Tea, UUID> {

}
