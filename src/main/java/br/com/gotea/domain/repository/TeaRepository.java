package br.com.gotea.domain.repository;

import br.com.gotea.domain.model.TeaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeaRepository extends JpaRepository<TeaModel, UUID> {

}
