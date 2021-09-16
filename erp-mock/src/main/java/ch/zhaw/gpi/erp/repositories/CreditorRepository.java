package ch.zhaw.gpi.erp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.gpi.erp.entities.Creditor;

public interface CreditorRepository extends JpaRepository<Creditor, Long> {
    
    public Optional<Creditor> findByCrName(String crName);
}
